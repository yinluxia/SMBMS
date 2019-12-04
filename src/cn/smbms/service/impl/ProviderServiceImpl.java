package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.provider.ProviderMapper;
import cn.smbms.pojo.Provider;
import cn.smbms.service.ProviderService;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
	@Resource
	private ProviderMapper providerMapper;
	
	@Override
	public int getProCount(String proCode, String proName) {
		return providerMapper.getProCount(proCode, proName);
	}

	@Override
	public List<Provider> getProList(String proCode, String proName,
			Integer from, Integer pageSize) {
		return providerMapper.getProList(proCode, proName, from, pageSize);
	}

}
