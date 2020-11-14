package com.moa.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.moa.web.vo.ProductView;

@Mapper
public interface ProductDao {

//	list
	@Select("SELECT * FROM ProductView WHERE mfr LIKE '%${mfr}%' AND name LIKE '%${search}%' AND name LIKE '%${cup}%' ORDER BY name LIMIT ${page}, 16")
	public List<ProductView> getProductList(int page, String mfr, String search, String cup)
			throws SQLException, ClassNotFoundException;

//	rank
	@Select("SELECT * FROM ProductView WHERE mfr LIKE '%${mfr}%' AND name LIKE '%${search}%' AND name LIKE '%${cup}%' ORDER BY amount LIMIT 10")
	public List<ProductView> getProductRank(int page, String mfr, String search, String cup)
			throws SQLException, ClassNotFoundException;

//	detail
	@Select("SELECT * FROM ProductView WHERE id = #{id}")
	public ProductView getNutrition(int id) throws SQLException, ClassNotFoundException;

//	insert
	@Insert("INSERT INTO Product(name, capacity, kcal, manufacturerId, img) VALUES(#{name}, #{capacity}, #{kcal}, #{mfrId}, #{path})")
	public void insertProduct(ProductView productView, String path) throws SQLException, ClassNotFoundException;

//	@Insert("INSERT INTO Nutrition(name, capacity, kcal, manufacturerId, img) VALUES(#{name}, #{capacity}, #{kcal}, #{mfrId}, #{path})")
//	public void insertNutrition(ProductView productView) throws SQLException, ClassNotFoundException;

	@Insert("INSERT INTO Manufacturer(name, logo) VALUES(#{name}, #{logo})")
	public void insertMfr(ProductView productView) throws SQLException, ClassNotFoundException;

	@Insert("INSERT INTO Sales(productId, amount, year, quarter) VALUES(#{id}, #{capacity}, #{amount}, #{year}, #{quarter})")
	public void insertSales(ProductView productView) throws SQLException, ClassNotFoundException;

//	admin-list
	@Select("SELECT * FROM ProductView WHERE mfr LIKE '%${mfr}%' AND name LIKE '%${search}%' AND name LIKE '%${cup}%' ORDER BY name LIMIT 5")
	public List<ProductView> getProductAdminList(int page, String mfr, String search, String cup)
			throws SQLException, ClassNotFoundException;

//	update	
	@Update("UPDATE Product SET name = #{name}, capacity = #{capacity}, kcal = #{kcal}, manufacturerId = #{manufacturerId}, img = #{path} WHERE id = #{id}")
	public void updateProduct(ProductView productView, String path) throws SQLException, ClassNotFoundException;

	@Update("UPDATE Nutrition SET natrium = #{natrium} WHERE productId = #{id} AND title = '나트륨'")
	public void updateNatrium(ProductView productView) throws SQLException, ClassNotFoundException;

	@Update("UPDATE Nutrition SET content = #{carbohydrate} WHERE productId = #{id} AND title = '탄수화물'")
	public void updateCarbohydrate(ProductView productView) throws SQLException, ClassNotFoundException;

	@Update("UPDATE Nutrition SET content = #{sugars} WHERE productId = #{id} AND title = '당류'")
	public void updateSugars(ProductView productView) throws SQLException, ClassNotFoundException;

	@Update("UPDATE Nutrition SET content = #{fat} WHERE productId = #{id} AND title = '지방'")
	public void updateFat(ProductView productView) throws SQLException, ClassNotFoundException;

	@Update("UPDATE Nutrition SET content = #{transfat} WHERE productId = #{id} AND title = '트랜스지방'")
	public void updateTransfat(ProductView productView) throws SQLException, ClassNotFoundException;

	@Update("UPDATE Nutrition SET content = #{saturatedFat} WHERE productId = #{id} AND title = '포화지방'")
	public void updateSaturatedFat(ProductView productView) throws SQLException, ClassNotFoundException;

	@Update("UPDATE Nutrition SET content = #{cholesterol} WHERE productId = #{id} AND title = '콜레스테롤'")
	public void updateCholesterol(ProductView productView) throws SQLException, ClassNotFoundException;

	@Update("UPDATE Nutrition SET content = #{protein} WHERE productId = #{id} AND title = '단백질'")
	public void updateProtein(ProductView productView) throws SQLException, ClassNotFoundException;

	@Update("UPDATE Manufacturer SET name = #{mfr}, logo = #{logo} WHERE id = #{mfrId}")
	public void updateMfr(ProductView productView) throws SQLException, ClassNotFoundException;

	@Update("UPDATE Sales SET amount = #{amount}, year = #{year}, quarter = #{quarter}  WHERE productId = #{id}")
	public void updateSales(ProductView productView) throws SQLException, ClassNotFoundException;

// 	del
	@Delete("DELETE FROM Product WHERE id = #{id}")
	public void delProduct(int id) throws SQLException, ClassNotFoundException;
}
