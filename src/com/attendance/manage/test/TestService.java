package com.attendance.manage.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by IntelliJ IDEA. User: Thinkpad2 Date: 13-1-28 Time: 上午1:13 To
 * change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/*.xml" })
public class TestService {
	// @Autowired
	// private DealsDao dealsDao;
	// @Autowired
	// private JuDao juDao;
	// @Autowired
	// private RedEnvelopeDealMapper redEnvelopeDealMapper;
	//
	// @Test
	// public void test() {
	// // List<Map> cpcs=new ArrayList<Map>();
	// // cpcs=dealsDao.getCpcAll();
	// // System.out.println("cpcs:"+cpcs.size());
	// // DateTime dateTime1=new DateTime();
	// // List<Map> list=sortList(cpcs);
	// // DateTime dateTime2=new DateTime();
	// //
	// System.out.println("共计耗时:"+(dateTime2.getMillis()-dateTime1.getMillis())/1000+" s");
	// // for(Map map:list){
	// // Integer shopId=(Integer)map.get("tb_shop_id");
	// // Integer id=(Integer)map.get("id");
	// // Integer price=(Integer)map.get("per_click_price");
	// // System.out.println("id:"+id+",shopId:"+shopId+",price:"+price);
	// // }
	// // System.out.println("list:"+list.size());
	// // Integer total=juDao.getRedEnvelopeCount(null,null,null);
	// // System.out.println(total);
	// // List list=juDao.getRedEnvelopeList(null,null,null,0,10);
	// // System.out.println(list.size());
	// // List<EggStatBvo> eggStatBvoList=juDao.getEggStat(1);
	// // System.out.println(eggStatBvoList.size());
	// // System.out.println(eggStatBvoList.toString());
	//
	// }
	//
	// public List<Map> sortList(List<Map> cpcs) {
	// System.out.println("=======开始判重");
	// // 行数
	// int num = 0;
	// int num2 = -1;
	// List<Map> list = new ArrayList<Map>();
	// int lastShopId = 0;
	// List<Map> removeList = new ArrayList<Map>();
	// for (Map map : cpcs) {
	// Integer shopId = (Integer) map.get("tb_shop_id");
	// if (lastShopId == shopId.intValue()) {
	// System.out.println("发现重复 shopId:" + shopId + ",num:" + num);
	// // 发现连续重复，开始计数
	// list.add(map);
	// removeList.add(map);
	// if (num2 == -1) {
	// num2 = num;
	// }
	// } else if (list.size() > 0 && lastShopId != shopId.intValue()) {
	// // 发现不重复了，停止计数
	// // cpcs.addAll(num2,list);
	// // //继续判重
	// // return sortList(cpcs);
	// System.out.println("不重复了，停止判重");
	// break;
	// } else {
	// // 未发现重复
	// }
	// lastShopId = shopId;
	// num++;
	// }
	// cpcs.removeAll(removeList);
	// if (list.size() > 0) {
	// System.out.println("num2:" + num2 + ",cpcs:" + cpcs.size());
	// List<Integer> shopIds = new ArrayList<Integer>();
	// for (int i = num2; i < cpcs.size(); i++) {
	// Map map = cpcs.get(i);
	// Integer shopId = (Integer) map.get("tb_shop_id");
	// if (lastShopId != shopId.intValue()) {
	// if (!shopIds.contains(shopId)) {
	// shopIds.add(shopId);
	// if (shopIds.size() == 5) {
	// // 间隔了5个商铺的产品了，开始插入啊
	// if (i + 1 < cpcs.size() - 1) {
	// cpcs.addAll(i + 1, list);
	// } else {
	// cpcs.addAll(i, list);
	// }
	// return sortList(cpcs);
	// }
	// }
	// }
	// }
	// }
	// return cpcs;
	// }
}
