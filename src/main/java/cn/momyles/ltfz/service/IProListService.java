package cn.momyles.ltfz.service;

import cn.momyles.ltfz.pojo.ProList;

/**
 * 产品列表业务接口
 * @author MoMyles
 * @date 2015-11-22 21:04
 */
public interface IProListService {
	/**
	 * 新增一个产品
	 * @param proList 封装一个产品信息
	 * @author MoMyles
	 * @date 2015-11-22 20:50
	 */
	public abstract void save(ProList proList);
	/**
	 * 更新产品信息
	 * @param proList 封装需要更新的产品信息
	 * @author MoMyles
	 * @date 2015-11-22 20:52
	 */
	public abstract void update(ProList proList);
	/**
	 * 逻辑删除操作
	 * @param plId 需要删除的产品ID
	 */
	public abstract void delete(Integer plId);
	/**
	 * 根据ID，查询指定的产品信息
	 * @param plId 需要查询的产品信息的ID
	 * @author MoMyles
	 * @date 2015-11-22 21:11
	 */
	public abstract ProList findById(Integer plId);
}
