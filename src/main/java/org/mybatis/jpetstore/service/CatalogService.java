/*
 *    Copyright 2010-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.jpetstore.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.jpetstore.domain.*;
import org.mybatis.jpetstore.mapper.CategoryMapper;
import org.mybatis.jpetstore.mapper.EnvironmentMapper;
import org.mybatis.jpetstore.mapper.ItemMapper;
import org.mybatis.jpetstore.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class CatalogService.
 *
 * @author Eduardo Macarron
 */
@Service
public class CatalogService {

  private final CategoryMapper categoryMapper;
  private final ItemMapper itemMapper;
  private final ProductMapper productMapper;
  private final EnvironmentMapper environmentMapper;

  public CatalogService(CategoryMapper categoryMapper, ItemMapper itemMapper, ProductMapper productMapper, EnvironmentMapper environmentMapper) {
    this.categoryMapper = categoryMapper;
    this.itemMapper = itemMapper;
    this.productMapper = productMapper;
    this.environmentMapper = environmentMapper;
  }

  public List<Category> getCategoryList() {
    return categoryMapper.getCategoryList();
  }

  public Category getCategory(String categoryId) {
    return categoryMapper.getCategory(categoryId);
  }

  public Product getProduct(String productId) {
    return productMapper.getProduct(productId);
  }

  public List<Product> getProductListByCategory(String categoryId) {
    return productMapper.getProductListByCategory(categoryId);
  }

  /**
   * Search product list.
   *
   * @param keywords the keywords
   * @return the list
   */
  public List<Product> searchProductList(String keywords) {
    List<Product> products = new ArrayList<>();
    for (String keyword : keywords.split("\\s+")) {
      products.addAll(productMapper.searchProductList("%" + keyword.toLowerCase() + "%"));
    }
    return products;
  }

  public List<Item> getItemListByProduct(String productId) {
    return itemMapper.getItemListByProduct(productId);
  }

  public List<Item> getAllItemList() {
    return itemMapper.getAllItemList();
  }

  public Item getItem(String itemId) {
    return itemMapper.getItem(itemId);
  }

  public boolean isItemInStock(String itemId) {
    return itemMapper.getInventoryQuantity(itemId) > 0;
  }

  public List<Product> getAllProductListByAdmin() {
    return productMapper.getProductListByAdmin();
  }

  public void deleteItemByAdmin(String itemId) {
    itemMapper.deleteItemByAdmin(itemId);
  }

  @Transactional
  public void insertItemByAdmin(Item item) {
    itemMapper.insertItemByAdmin(item);
    itemMapper.insertInventoryByAdmin(item);
  }

  public void updateItemByAdmin(Item item) {
    itemMapper.updateItemByAdmin(item);
    itemMapper.updateInventoryByAdmin(item);
  }

  public List<AnimalInfo> getAnimalInfo(String categoryId, String productId) {
    return itemMapper.getAnimalInfo(categoryId, productId);
  }

  public List<EnvironmentByUser> getUserEnvList(String categoryId, String username) {
    return environmentMapper.getUserEnvList(categoryId, username);
  }

  public void updateAnimalInfoValueByAdmin(AnimalInfo animalInfo) {
    itemMapper.updateAnimalInfoValueByAdmin(animalInfo);
  }

  public int getAnimalInfoValueId(String categoryId, String productId, String columname) {
    return itemMapper.getAnimalInfoValueId(categoryId, productId, columname);
  }

  public void insertAnimalInfoColumnByAdmin(AnimalInfo animalInfo) {
    itemMapper.insertAnimalInfoColumnByAdmin(animalInfo);
  }

  public int getColumnIdByAdmin(String columname) {
    return itemMapper.getColumnIdByAdmin(columname);
  }

  public void insertAnimalInfoByAdmin(int columnId, int animalinfovalueId, String categoryId, String productId) {
    itemMapper.insertAnimalInfoByAdmin(columnId, animalinfovalueId, categoryId, productId);
  }

  public void deleteAnimalInfoByAdmin(String categoryId, int columnId) {
    itemMapper.deleteAnimalInfoByAdmin(categoryId, columnId);
  }

  public int getAnimalInfoColumnId(String columname) {
    return itemMapper.getAnimalInfoColumnId(columname);
  }

  public List<EnvironmentByProduct> getProductEnvList(String categoryId, String productId) {
    return environmentMapper.getProductEnvList(categoryId, productId);
  }

  public List<ProductEnvValue> getProductEnvValueList(String categoryId, String envColumnName) {
    return environmentMapper.getProductEnvValueList(categoryId, envColumnName);
  }

  public void updateEnvValueByAdmin(String envColumnName, String envValue, String productId) {
    environmentMapper.updateEnvValueByAdmin(envColumnName, envValue, productId);
  }

  public int getLastAccessColumnId() {
    return itemMapper.getLastAccessColumnId();
  }

  public List<Product> getProductListAboutCategoryByAdmin(String categoryId) {
    return productMapper.getProductListAboutCategoryByAdmin(categoryId);
  }

  public boolean isColumnIdExist(String columname) {
    return itemMapper.isColumnIdExist(columname);
  }

  public void insertNullIntoValue() {
    itemMapper.insertNullIntoValue();
  }

  public void deleteAnimalInfoValueByAdmin(String categoryId, int columnId, String productId) {
    itemMapper.deleteAnimalInfoValueByAdmin(categoryId, columnId, productId);
  }

  public boolean isExistAnimalInfo(int columnId, String categoryId) {
    return itemMapper.isExistAnimalInfo(columnId, categoryId);
  }

  public void returnToTrueExistAnimalInfo(int columnId, String categoryId) {
    itemMapper.returnToTrueExistAnimalInfo(columnId, categoryId);
  }

  public void deleteEnvColumnByAdmin(String categoryId, String envColumnName) {
    environmentMapper.deleteEnvColumnByAdmin(categoryId, envColumnName);
  }

  public List<EnvironmentByProduct> getProductEnvColumnByCategoryId(String categoryId) {
    return environmentMapper.getProductEnvColumnByCategoryId(categoryId);
  }

  public List<EnvironmentByProduct> getEnvItem(String categoryId, String envColumnName) {
    return environmentMapper.getEnvItem(categoryId, envColumnName);
  }

  public void settingUserEnv(String categoryId, String envColumnName, String username, String envValue) {
    environmentMapper.settingUserEnv(categoryId, envColumnName, username, envValue);
  }

  public void insertProductByAdmin(Product product) {
    productMapper.insertProductByAdmin(product);
  }

  public List<AnimalInfoColumn> getAnimalInfoColumnList(String categoryId) {
    return itemMapper.getAnimalInfoColumnList(categoryId);
  }

  public boolean isExistProductenvrionmentId(String productId) {
    return environmentMapper.isExistProductenvrionmentId(productId);
  }

  public void insertEnvValueByAdmin(String categoryId, String productId, String envColumnName, String envValue) {
    environmentMapper.insertEnvValueByAdmin(categoryId, productId, envColumnName, envValue);
  }

  public List<AnimalInfo> getAnimalInfoColumnName(String categoryId) {
    return itemMapper.getAnimalInfoColumnName(categoryId);
  }

  public void insertProductValueByAdmin(int columnId, int animalinfovalueId, String categoryId, String productId) {
    itemMapper.insertProductValueByAdmin(columnId, animalinfovalueId, categoryId, productId);
  }

  public void updateAnimalInfoByAdmin(int columnId, int animalinfovalueId, String categoryId, String productId) {
    itemMapper.updateAnimalInfoByAdmin(columnId, animalinfovalueId, categoryId, productId);
  }
}