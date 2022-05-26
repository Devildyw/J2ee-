package org.cuit.controller;


import org.cuit.mapper.DownloadMapper;
import org.cuit.pojo.Download;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Controller
public class DownloadController {

    @Autowired
    DownloadMapper downloadMapper;

    @GetMapping({"/download"})
    public String download(Model model){
        List<Download> downloadList = downloadMapper.selectList(null);
        model.addAttribute("downloadList",downloadList);
        return "page/download";
    }

}

