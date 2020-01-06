package my.springboot.myspringmvc.service;

import my.springboot.myspringmvc.dao.ProductMapper;
import my.springboot.myspringmvc.dao.PurchaseRecordMapper;
import my.springboot.myspringmvc.pojo.Product;
import my.springboot.myspringmvc.pojo.PurchaseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper;

    @Override
    //启动spring 数据库事务机制
    @Transactional
    public boolean purchase(Integer userId, Integer productId, int quantity) {
        //获取产品
        Product product = productMapper.selectByPrimaryKey(productId);
        //比较库存和购买数量
        if (product.getStock() < quantity) {
            //库存不足
            return false;
        }
        //扣减库存
        productMapper.decreaseProduct(productId, quantity);
        //初始化购买记录
        PurchaseRecord purchaseRecord = this.initPurchaseRecord(userId, product, quantity);
        //插入购买记录
        purchaseRecordMapper.insert(purchaseRecord);
        return true;
    }

    //初始化购买信息
    private PurchaseRecord initPurchaseRecord(Integer userId, Product product, int quantity) {
        PurchaseRecord pr = new PurchaseRecord();
        pr.setNote("购买日志，时间："+System.currentTimeMillis());
        pr.setPrice(product.getPrice());
        pr.setProductId(product.getId());
        pr.setQuantity(quantity);
        double sum = product.getPrice()*quantity;
        pr.setSum(sum);
        pr.setUserId(userId);
        return pr;
    }
}
