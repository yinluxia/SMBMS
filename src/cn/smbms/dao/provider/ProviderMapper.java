package cn.smbms.dao.provider;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Provider;

public interface ProviderMapper {

	/**
	 * 按照条件查询供应商记录
	 * @param proCode 根据供应商编码模糊查询
	 * @param proName 根据供应商名称模糊查询
	 * @return 返回查询后的记录
	 */
	public int getProCount(@Param("proCode") String proCode,
			@Param("proName") String proName);

	/**
	 * 按照条件查询供应商列表分页显示
	 * @param proCode 根据供应商编码模糊查询
	 * @param proName 根据供应商名称模糊查询
	 * @param from 分页的起始位置
	 * @param pageSize 每页显示的大小
	 * @return
	 */
	public List<Provider> getProList(@Param("proCode") String proCode,
			@Param("proName") String proName, @Param("from") Integer from,
			@Param("pageSize") Integer pageSize);
}
