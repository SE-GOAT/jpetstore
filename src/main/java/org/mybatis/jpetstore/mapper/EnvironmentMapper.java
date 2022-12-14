package org.mybatis.jpetstore.mapper;

import org.apache.ibatis.annotations.Param;
import org.mybatis.jpetstore.domain.EnvironmentByProduct;
import org.mybatis.jpetstore.domain.EnvironmentByUser;
import org.mybatis.jpetstore.domain.ProductEnvValue;

import java.util.List;

public interface EnvironmentMapper {
    List<EnvironmentByUser> getUserEnvList(@Param("categoryId") String categoryId, @Param("username") String username);

    List<EnvironmentByProduct> getProductEnvList(@Param("categoryId") String categoryId, @Param("productId") String productId);

    List<ProductEnvValue> getProductEnvValueList(@Param("categoryId") String categoryId, @Param("envColumnName") String envColumnName);

    void updateEnvValueByAdmin(@Param("envColumnName") String envColumnName, @Param("envValue") String envValue, @Param("productId") String productId);

    List<EnvironmentByProduct> getProductEnvColumnByCategoryId(String categoryId);

    List<EnvironmentByProduct> getEnvItem(@Param("categoryId") String categoryId, @Param("envColumnName") String envColumnName);

    void deleteEnvColumnByAdmin(@Param("categoryId") String categoryId, @Param("envColumnName") String envColumnName);

    void settingUserEnv(@Param("categoryId") String categoryId, @Param("envColumnName") String envColumnName, @Param("username") String username, @Param("envValue") String envValue);

    boolean isExistProductenvrionmentId(@Param("productId") String productId);

    void insertEnvValueByAdmin(@Param("categoryId") String categoryId, @Param("productId") String productId, @Param("envColumnName") String envColumnName, @Param("envValue") String envValue);
}
