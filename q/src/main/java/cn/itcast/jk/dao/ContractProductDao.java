package cn.itcast.jk.dao;

import cn.itcast.jk.domain.ContractProduct;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by root on 2017/5/22.
 */
public interface ContractProductDao extends BaseDao<ContractProduct> {
    void deleteByContractProductById(Serializable[] ids);
    void deleteByContractId(Serializable[] ids);
}
