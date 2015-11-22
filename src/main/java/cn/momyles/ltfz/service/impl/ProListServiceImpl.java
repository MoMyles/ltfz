package cn.momyles.ltfz.service.impl;

import cn.momyles.ltfz.pojo.ProList;
import cn.momyles.ltfz.service.IProListService;
/**
 * 产品列表业务实现
 * @author MoMyles
 * @date 2015-11-22 21:10
 */
public class ProListServiceImpl implements IProListService {
	/**
	 * 新增一个产品
	 * @param proList 封装一个产品信息
	 * @author MoMyles
	 * @date 2015-11-22 20:50
	 */
	public void save(ProList proList) {
		proList.save();
	}
	/**
	 * 更新产品信息
	 * @param proList 封装需要更新的产品信息
	 * @author MoMyles
	 * @date 2015-11-22 20:52
	 */
	public void update(ProList proList) {
		proList.update();
	}
	/**
	 * 逻辑删除操作
	 * @param plId 需要删除的产品ID
	 */
	public void delete(Integer plId) {
		ProList.dao.findById(plId).set("pl_state", 0).update();
	}
	/**
	 * 根据ID，查询指定的产品信息
	 * @param plId 需要查询的产品信息的ID
	 * @author MoMyles
	 * @date 2015-11-22 21:11
	 */
	public ProList findById(Integer plId) {
		return ProList.dao.findById(plId);
	}
 
}
