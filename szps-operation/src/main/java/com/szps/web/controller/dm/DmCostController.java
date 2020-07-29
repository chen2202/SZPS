package com.szps.web.controller.dm;


import com.szps.common.annotation.Log;
import com.szps.common.config.Global;
import com.szps.common.constant.Constants;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.core.text.Convert;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.StringUtils;
import com.szps.common.utils.file.FileUploadUtils;
import com.szps.common.utils.file.FileUtils;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysUser;
import com.szps.system.service.ISysUserService;
import com.szps.web.domain.dm.DmCost;
import com.szps.web.service.dm.IDmCostService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipOutputStream;

/**
 * 污水处理费资料管理
 *
 * @author vic
 *
 */
@Controller
@RequestMapping("/dm/cost")
public class DmCostController extends BaseController {

    private String prefix = "dm/cost";

    @Autowired
    private IDmCostService costService;

    @GetMapping()
    public String show()
    {
        return prefix + "/cost";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DmCost dmCost) throws Exception{
        if(sql_inj(dmCost.getCostFactory())||sql_inj(dmCost.getCostPunishReason()))
        {
            throw new Exception("输入字符非法！！");
        }

        startPage();
        List<DmCost> list = costService.selectCostList(dmCost);
        return getDataTable(list);
    }

    /**
     *
     * 添加污水处理费资料
     *
     */
    @GetMapping("/add")
    public String add(HttpServletRequest request)
    {
        return prefix + "/add";
    }


    /**
     * 新增资料
     */
    @Log(title = "添加污水费资料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional
    @ResponseBody
    public AjaxResult addSave(@Validated DmCost dmCost,@RequestParam("file") MultipartFile file) throws IOException {

        // 上传文件
        String filePath = Global.getUploadPath();       // 上传文件路径
        String path = FileUploadUtils.upload(filePath, file);   //文件路径
        String fileName = file.getOriginalFilename();           //获取文件名

        // 存储资料
        String loginName = ShiroUtils.getLoginName();

        dmCost.setCostFileName(fileName);
        dmCost.setCostFilePath(path);

        int result = costService.insertCost(dmCost);
        if(result>0){
            return success("添加成功");
        }else{
            return error("添加失败!");
        }

    }


    /**
     *删除资料
     */
    @Log(title = "删除污水费资料", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @Transactional
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            // 删除资料文件
            Long[] costIds = Convert.toLongArray(ids);
            for(int i=0;i<costIds.length;i++){
                DmCost dmCost = costService.selectCostById(costIds[i]);
                String filePath = dmCost.getCostFilePath();
                filePath = Global.getUploadPath() + filePath.replace("/profile/upload", "");
                FileUtils.deleteFile(filePath);
            }

            // 删除数据库记录
            int result = costService.deleteCostByIds(costIds);
            if(result>0){
                return success("删除成功!");
            }else{
                return error("删除失败!");
            }
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 修改资料
     */
    @GetMapping("/edit/{costId}")
    public String edit(@PathVariable("costId") Long costId, ModelMap mmap)
    {
        DmCost cost = costService.selectCostById(costId);
        mmap.put("cost",cost);
        return prefix + "/edit";
    }

    /**
     * 修改污水费资料
     */
    @Log(title = "修改污水费资料", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated DmCost dmCost)
    {
        return toAjax(costService.updateCost(dmCost));
    }

    /**
     * 文件下载请求
     * 支持单文件
     */
    @Log(title = "下载污水费资料文件", businessType = BusinessType.OTHER)
    @GetMapping("/download")
    @ResponseBody
    public void resourceDownload(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 通过文件编号获取文件
        DmCost dmCost = costService.selectCostById(Long.parseLong(id));

        if (dmCost != null) {
            String fileName = dmCost.getCostFileName();
            String filePath = dmCost.getCostFilePath();

            // 本地资源路径
            String localPath = Global.getProfile();
            // 数据库资源地址
            String downloadPath = localPath + StringUtils.substringAfter(filePath, "/profile");

            // 下载
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, fileName));
            FileUtils.writeBytes(downloadPath, response.getOutputStream());
        }
    }

    public static boolean sql_inj(String str){

        String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";

        String inj_stra[] = inj_str.split("|");

        for (String anInj_stra : inj_stra) {

            if (str.contains(anInj_stra)) {

                return true;

            }

        }

        return false;
    }
}
