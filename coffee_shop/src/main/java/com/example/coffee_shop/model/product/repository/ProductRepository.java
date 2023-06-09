package com.example.coffee_shop.model.product.repository;

import com.example.coffee_shop.BaseRepository;
import com.example.coffee_shop.model.product.model.Product;
import com.example.coffee_shop.model.product.model.TypeProduct;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_PRODUCT =  " select * from product " +
            "join product_type on product_type.product_type_id = product.product_type_id; ";
    private static final String INSERT_PRODUCT = "insert into product(product_name,product_price,product_description,product_image,product_type_id) " +
            "values (?,?,?,?,?);";

    private static final String DELETE_BY_ID = "delete from product where product_id = ?;";
    private static final String UPDATE_PRODUCT = "UPDATE product SET product_name = ?, product_price =?, product_description = ?, product_image = ?,product_type_id=? WHERE product_id = ?;";

    @Override
    public List<Product> productList() {
        Connection connection = baseRepository.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCT);
            while (resultSet.next()){
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                double price = resultSet.getDouble("product_price");
                String description = resultSet.getString("product_description");
                String image = resultSet.getString("product_image");
                int idTypeProduct = resultSet.getInt("product.product_type_id");
                String nameTypeProduct = resultSet.getString("product_type_name");
                TypeProduct typeProduct = new TypeProduct(idTypeProduct,nameTypeProduct);
                productList.add(new Product(id,name,price,description,image,typeProduct));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }

    @Override
    public boolean findByName(String name) {
        for (int i = 0; i < productList().size(); i++) {
            if(productList().get(i).getProductName().equals(name)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void createProduct(Product product, int id) {
        if(findByName(product.getProductName())){
            Connection connection = baseRepository.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
                preparedStatement.setString(1,product.getProductName());
                preparedStatement.setDouble(2,product.getProductPrice());
                preparedStatement.setString(3,product.getProductDescription());
                preparedStatement.setString(4,product.getProductImage());
                preparedStatement.setInt(5,id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void updateProduct(int id, Product product,String name) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setDouble(2,product.getProductPrice());
            preparedStatement.setString(3,product.getProductDescription());
            preparedStatement.setString(4,product.getProductImage());
            preparedStatement.setObject(5,name);
            preparedStatement.setInt(6,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT product.*,product_type.product_type_name from product join product_type on product_type.product_type_id = product.product_type_id where product_name like '%"+name+"%';");
            while (resultSet.next()){
                int id = resultSet.getInt("product_id");
                String newName = resultSet.getString("product_name");
                double price = resultSet.getDouble("product_price");
                String description = resultSet.getString("product_description");
                String image = resultSet.getString("product_image");
                int idTypeProduct = resultSet.getInt("product.product_type_id");
                String nameTypeProduct = resultSet.getString("product_type_name");
                TypeProduct typeProduct = new TypeProduct(idTypeProduct,nameTypeProduct);
                productList.add(new Product(id,newName,price,description,image,typeProduct));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }


    @Override
    public Product getProductById(int id) {
        Connection connection = baseRepository.getConnection();
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product join product_type on product_type.product_type_id = product.product_type_id where product_id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idd = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                double price = resultSet.getDouble("product_price");
                String description = resultSet.getString("product_description");
                String image = resultSet.getString("product_image");
                int idTypeProduct = resultSet.getInt("product.product_type_id");
                String nameTypeProduct = resultSet.getString("product_type_name");
                TypeProduct typeProduct = new TypeProduct(idTypeProduct, nameTypeProduct);
                product = new Product(idd, name, price, description, image, typeProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    @Override
    public List<Product> productListByType(int idType) {
        List<Product> productList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT product.*,product_type.product_type_name from product join product_type on product_type.product_type_id = product.product_type_id where product_type.product_type_id =?;");
            preparedStatement.setInt(1, idType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("product_id");
                String newName = resultSet.getString("product_name");
                double price = resultSet.getDouble("product_price");
                String description = resultSet.getString("product_description");
                String image = resultSet.getString("product_image");
                int idTypeProduct = resultSet.getInt("product.product_type_id");
                String nameTypeProduct = resultSet.getString("product_type_name");
                TypeProduct typeProduct = new TypeProduct(idTypeProduct,nameTypeProduct);
                productList.add(new Product(id,newName,price,description,image,typeProduct));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

}