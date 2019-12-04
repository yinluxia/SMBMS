package cn.smbms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.constans.Constants;
import cn.smbms.pojo.Page;
import cn.smbms.pojo.Provider;
import cn.smbms.service.ProviderService;

import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/provider")
public class ProviderController {
	@Resource
	private ProviderService providerService;

	@RequestMapping("/proList")
	public String providerList(@RequestParam(value="queryProCode",required=false) String proCode,
			@RequestParam(value="queryProName",required=false) String proName,
			@RequestParam(value="pageIndex",required=false) String pageIndex, Model model) {
		int currPageNo = 1;	//当前页
		if(!StringUtils.isNullOrEmpty(pageIndex)){
			currPageNo = Integer.valueOf(pageIndex);
		}
		int pageSize = Constants.pageSize;	//页大小
		int from = (currPageNo - 1) * pageSize;	//起始位置
		int totalCount = providerService.getProCount(proCode, proName);
		System.out.println(pageSize);
		Page page = new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPageNo(currPageNo);
		List<Provider> proList = providerService.getProList(proCode, proName, from, pageSize);
		model.addAttribute("providerList", proList);
		model.addAttribute("page", page);
		model.addAttribute("queryProCode", proCode);
		model.addAttribute("queryProName", proName);
		return "/providerlist";
	}
}
