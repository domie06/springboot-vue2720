
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 商品订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kafeiOrder")
public class KafeiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(KafeiOrderController.class);

    @Autowired
    private KafeiOrderService kafeiOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private AddressService addressService;
    @Autowired
    private KafeiService kafeiService;
    @Autowired
    private YonghuService yonghuService;
@Autowired
private CartService cartService;
@Autowired
private KafeiCommentbackService kafeiCommentbackService;
@Autowired
private ShangjiaService shangjiaService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("商家".equals(role))
            params.put("shangjiaId",request.getSession().getAttribute("userId"));
        else if("志愿者".equals(role))
            params.put("zhiyuanzheId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = kafeiOrderService.queryPage(params);

        //字典表数据转换
        List<KafeiOrderView> list =(List<KafeiOrderView>)page.getList();
        for(KafeiOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KafeiOrderEntity kafeiOrder = kafeiOrderService.selectById(id);
        if(kafeiOrder !=null){
            //entity转view
            KafeiOrderView view = new KafeiOrderView();
            BeanUtils.copyProperties( kafeiOrder , view );//把实体数据重构到view中

                //级联表
                AddressEntity address = addressService.selectById(kafeiOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                    view.setAddressYonghuId(address.getYonghuId());
                }
                //级联表
                KafeiEntity kafei = kafeiService.selectById(kafeiOrder.getKafeiId());
                if(kafei != null){
                    BeanUtils.copyProperties( kafei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKafeiId(kafei.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(kafeiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KafeiOrderEntity kafeiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kafeiOrder:{}",this.getClass().getName(),kafeiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            kafeiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        kafeiOrder.setInsertTime(new Date());
        kafeiOrder.setCreateTime(new Date());
        kafeiOrderService.insert(kafeiOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KafeiOrderEntity kafeiOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kafeiOrder:{}",this.getClass().getName(),kafeiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            kafeiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<KafeiOrderEntity> queryWrapper = new EntityWrapper<KafeiOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KafeiOrderEntity kafeiOrderEntity = kafeiOrderService.selectOne(queryWrapper);
        if(kafeiOrderEntity==null){
            kafeiOrderService.updateById(kafeiOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kafeiOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<KafeiOrderEntity> kafeiOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            KafeiOrderEntity kafeiOrderEntity = new KafeiOrderEntity();
//                            kafeiOrderEntity.setKafeiOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            kafeiOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收货地址 要改的
//                            kafeiOrderEntity.setKafeiId(Integer.valueOf(data.get(0)));   //商品 要改的
//                            kafeiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            kafeiOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            kafeiOrderEntity.setKafeiOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            kafeiOrderEntity.setKafeiOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            kafeiOrderEntity.setKafeiOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            kafeiOrderEntity.setInsertTime(date);//时间
//                            kafeiOrderEntity.setCreateTime(date);//时间
                            kafeiOrderList.add(kafeiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("kafeiOrderUuidNumber")){
                                    List<String> kafeiOrderUuidNumber = seachFields.get("kafeiOrderUuidNumber");
                                    kafeiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> kafeiOrderUuidNumber = new ArrayList<>();
                                    kafeiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("kafeiOrderUuidNumber",kafeiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<KafeiOrderEntity> kafeiOrderEntities_kafeiOrderUuidNumber = kafeiOrderService.selectList(new EntityWrapper<KafeiOrderEntity>().in("kafei_order_uuid_number", seachFields.get("kafeiOrderUuidNumber")));
                        if(kafeiOrderEntities_kafeiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(KafeiOrderEntity s:kafeiOrderEntities_kafeiOrderUuidNumber){
                                repeatFields.add(s.getKafeiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        kafeiOrderService.insertBatch(kafeiOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = kafeiOrderService.queryPage(params);

        //字典表数据转换
        List<KafeiOrderView> list =(List<KafeiOrderView>)page.getList();
        for(KafeiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KafeiOrderEntity kafeiOrder = kafeiOrderService.selectById(id);
            if(kafeiOrder !=null){


                //entity转view
                KafeiOrderView view = new KafeiOrderView();
                BeanUtils.copyProperties( kafeiOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(kafeiOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    KafeiEntity kafei = kafeiService.selectById(kafeiOrder.getKafeiId());
                if(kafei != null){
                    BeanUtils.copyProperties( kafei , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKafeiId(kafei.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(kafeiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody KafeiOrderEntity kafeiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,kafeiOrder:{}",this.getClass().getName(),kafeiOrder.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            KafeiEntity kafeiEntity = kafeiService.selectById(kafeiOrder.getKafeiId());
            if(kafeiEntity == null){
                return R.error(511,"查不到该物品");
            }
            // Double kafeiNewMoney = kafeiEntity.getKafeiNewMoney();

            if(false){
            }
            else if((kafeiEntity.getKafeiKucunNumber() -kafeiOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }
            else if(kafeiEntity.getKafeiNewMoney() == null){
                return R.error(511,"物品价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - kafeiEntity.getKafeiNewMoney()*kafeiOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            kafeiOrder.setKafeiOrderTypes(3); //设置订单状态为已支付
            kafeiOrder.setKafeiOrderTruePrice(kafeiEntity.getKafeiNewMoney()*kafeiOrder.getBuyNumber()); //设置实付价格
            kafeiOrder.setYonghuId(userId); //设置订单支付人id
            kafeiOrder.setKafeiOrderPaymentTypes(1);
            kafeiOrder.setInsertTime(new Date());
            kafeiOrder.setCreateTime(new Date());
                kafeiEntity.setKafeiKucunNumber( kafeiEntity.getKafeiKucunNumber() -kafeiOrder.getBuyNumber());
                kafeiService.updateById(kafeiEntity);
                kafeiOrderService.insert(kafeiOrder);//新增订单
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);
            return R.ok();
        }else{
            return R.error(511,"您没有权限支付订单");
        }
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String kafeiOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Integer addressId = Integer.valueOf(String.valueOf(params.get("addressId")));

        Integer kafeiOrderPaymentTypes = Integer.valueOf(String.valueOf(params.get("kafeiOrderPaymentTypes")));//支付类型

        String data = String.valueOf(params.get("kafeis"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> kafeis = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<KafeiOrderEntity> kafeiOrderList = new ArrayList<>();
        //商家表
        ArrayList<ShangjiaEntity> shangjiaList = new ArrayList<>();
        //商品表
        List<KafeiEntity> kafeiList = new ArrayList<>();
        //购物车ids
        List<Integer> cartIds = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);

        //循环取出需要的数据
        for (Map<String, Object> map : kafeis) {
           //取值
            Integer kafeiId = Integer.valueOf(String.valueOf(map.get("kafeiId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            KafeiEntity kafeiEntity = kafeiService.selectById(kafeiId);//购买的商品
            String id = String.valueOf(map.get("id"));
            if(StringUtil.isNotEmpty(id))
                cartIds.add(Integer.valueOf(id));

            //获取商家信息
            Integer shangjiaId = kafeiEntity.getShangjiaId();
            ShangjiaEntity shangjiaEntity = shangjiaService.selectById(shangjiaId);//商家

            //判断商品的库存是否足够
            if(kafeiEntity.getKafeiKucunNumber() < buyNumber){
                //商品库存不足直接返回
                return R.error(kafeiEntity.getKafeiName()+"的库存不足");
            }else{
                //商品库存充足就减库存
                kafeiEntity.setKafeiKucunNumber(kafeiEntity.getKafeiKucunNumber() - buyNumber);
            }

            //订单信息表增加数据
            KafeiOrderEntity kafeiOrderEntity = new KafeiOrderEntity<>();

            //赋值订单信息
            kafeiOrderEntity.setKafeiOrderUuidNumber(kafeiOrderUuidNumber);//订单号
            kafeiOrderEntity.setAddressId(addressId);//收货地址
            kafeiOrderEntity.setKafeiId(kafeiId);//商品
            kafeiOrderEntity.setYonghuId(userId);//用户
            kafeiOrderEntity.setBuyNumber(buyNumber);//购买数量 ？？？？？？
            kafeiOrderEntity.setKafeiOrderTypes(3);//订单类型
            kafeiOrderEntity.setKafeiOrderPaymentTypes(kafeiOrderPaymentTypes);//支付类型
            kafeiOrderEntity.setInsertTime(new Date());//订单创建时间
            kafeiOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
            if(kafeiOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(kafeiEntity.getKafeiNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;
                    yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额


                    kafeiOrderEntity.setKafeiOrderTruePrice(money);

                    //修改商家余额
                    shangjiaEntity.setNewMoney(shangjiaEntity.getNewMoney()+money);
                }
            }
            kafeiOrderList.add(kafeiOrderEntity);
            shangjiaList.add(shangjiaEntity);
            kafeiList.add(kafeiEntity);

        }
        kafeiOrderService.insertBatch(kafeiOrderList);
        shangjiaService.updateBatchById(shangjiaList);
        kafeiService.updateBatchById(kafeiList);
        yonghuService.updateById(yonghuEntity);
        if(cartIds != null && cartIds.size()>0)
            cartService.deleteBatchIds(cartIds);
        return R.ok();
    }











    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

        if("用户".equals(role)){
            KafeiOrderEntity kafeiOrder = kafeiOrderService.selectById(id);
            Integer buyNumber = kafeiOrder.getBuyNumber();
            Integer kafeiOrderPaymentTypes = kafeiOrder.getKafeiOrderPaymentTypes();
            Integer kafeiId = kafeiOrder.getKafeiId();
            if(kafeiId == null)
                return R.error(511,"查不到该物品");
            KafeiEntity kafeiEntity = kafeiService.selectById(kafeiId);
            if(kafeiEntity == null)
                return R.error(511,"查不到该物品");
            //获取商家信息
            Integer shangjiaId = kafeiEntity.getShangjiaId();
            ShangjiaEntity shangjiaEntity = shangjiaService.selectById(shangjiaId);//商家
            Double kafeiNewMoney = kafeiEntity.getKafeiNewMoney();
            if(kafeiNewMoney == null)
                return R.error(511,"物品价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");

            Double zhekou = 1.0;


            //判断是什么支付方式 1代表余额 2代表积分
            if(kafeiOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = kafeiEntity.getKafeiNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


                //修改商家余额
                shangjiaEntity.setNewMoney(shangjiaEntity.getNewMoney() - money);
            }

            kafeiEntity.setKafeiKucunNumber(kafeiEntity.getKafeiKucunNumber() + buyNumber);



            kafeiOrder.setKafeiOrderTypes(2);//设置订单状态为退款
            kafeiOrderService.updateById(kafeiOrder);//根据id更新
            shangjiaService.updateById(shangjiaEntity);
            yonghuService.updateById(yonghuEntity);//更新用户信息
            kafeiService.updateById(kafeiEntity);//更新订单中物品的信息
            return R.ok();
        }else{
            return R.error(511,"您没有权限退款");
        }
    }


    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        KafeiOrderEntity  kafeiOrderEntity = new  KafeiOrderEntity();;
        kafeiOrderEntity.setId(id);
        kafeiOrderEntity.setKafeiOrderTypes(4);
        boolean b =  kafeiOrderService.updateById( kafeiOrderEntity);
        if(!b){
            return R.error("发货出错");
        }
        return R.ok();
    }









    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        KafeiOrderEntity  kafeiOrderEntity = new  KafeiOrderEntity();
        kafeiOrderEntity.setId(id);
        kafeiOrderEntity.setKafeiOrderTypes(5);
        boolean b =  kafeiOrderService.updateById( kafeiOrderEntity);
        if(!b){
            return R.error("收货出错");
        }
        return R.ok();
    }



    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer kafeiCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            KafeiOrderEntity kafeiOrder = kafeiOrderService.selectById(id);
        if(kafeiOrder == null)
            return R.error(511,"查不到该订单");
        if(kafeiOrder.getKafeiOrderTypes() != 5)
            return R.error(511,"您不能评价");
        Integer kafeiId = kafeiOrder.getKafeiId();
        if(kafeiId == null)
            return R.error(511,"查不到该物品");

        KafeiCommentbackEntity kafeiCommentbackEntity = new KafeiCommentbackEntity();
            kafeiCommentbackEntity.setId(id);
            kafeiCommentbackEntity.setKafeiId(kafeiId);
            kafeiCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            kafeiCommentbackEntity.setKafeiCommentbackText(commentbackText);
            kafeiCommentbackEntity.setReplyText(null);
            kafeiCommentbackEntity.setInsertTime(new Date());
            kafeiCommentbackEntity.setUpdateTime(null);
            kafeiCommentbackEntity.setCreateTime(new Date());
            kafeiCommentbackService.insert(kafeiCommentbackEntity);

            kafeiOrder.setKafeiOrderTypes(1);//设置订单状态为已评价
            kafeiOrderService.updateById(kafeiOrder);//根据id更新
            return R.ok();
        }else{
            return R.error(511,"您没有权限评价");
        }
    }







}
