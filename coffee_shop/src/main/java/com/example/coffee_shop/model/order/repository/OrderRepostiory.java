package com.example.coffee_shop.model.order.repository;

import com.example.coffee_shop.BaseRepository;
import com.example.coffee_shop.model.order.model.DetailOrder;
import com.example.coffee_shop.model.order.model.Order;
import com.example.coffee_shop.model.order.model.StatusOrder;
import com.example.coffee_shop.model.product.model.Product;
import com.example.coffee_shop.model.user.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepostiory implements IOrderRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ORDER = " SELECT o.*,`user`.user_name,sta.name_status FROM `order` as o " +
            " JOIN detail_order as detail on detail.order_id = o.order_id " +
            " JOIN product as pro on pro.product_id = detail.order_id " +
            " JOIN `status` as sta on sta.id = o.id_status " +
            " JOIN `user` on `user`.user_id = o.user_id " +
            " group by o.order_id";
    private static final String FIND_BY_ID ="CALL sp_find_order_by_id(?)";
    private static final String UPDATE_STATUS_ORDER = "update `order` " +
            " set id_status = ?+1 " +
            " where order_id = ?;";

    private static final String DELETE_ORDER = "call sp_delete_order_detail_order(?)";
    @Override
    public List<Order> displayOrder() {
        Connection connection = baseRepository.getConnection();
        List<Order> orders = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ORDER);
            while(resultSet.next()){
                int idOrder = resultSet.getInt("order_id");
                String orderDate = resultSet.getString("order_date");
                String comment = resultSet.getString("comment");
                String address = resultSet.getString("address");
                int idUser = resultSet.getInt("user_id");
                String nameUser = resultSet.getString("user_name");
                int idStatus = resultSet.getInt("id_status");
                String nameStatus = resultSet.getString("name_status");
                StatusOrder statusOrder =new StatusOrder(idStatus,nameStatus);
                User user = new User(idUser,nameUser);
                orders.add(new Order(idOrder,orderDate,comment,address,user,statusOrder));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }

    @Override
    public List<StatusOrder> displayStatus() {
        Connection connection = baseRepository.getConnection();
        List<StatusOrder> statusList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM status ;");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name_status");
                statusList.add(new StatusOrder(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statusList;
    }

    @Override
    public List<DetailOrder> findById(int id) {
        Connection connection = baseRepository.getConnection();
        List<DetailOrder> detailOrderList = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall(FIND_BY_ID);
            callableStatement.setInt(1,id);
            ResultSet resultSet =callableStatement.executeQuery();
            while (resultSet.next()){
                int idOrder = resultSet.getInt("order_id");
                String orderDate = resultSet.getString("order_date");
                String comment = resultSet.getString("comment");
                String address = resultSet.getString("address");
                int idUser = resultSet.getInt("user_id");
                String nameUser = resultSet.getString("user_name");
                int idStatus = resultSet.getInt("id_status");
                String nameStatus = resultSet.getString("name_status");
                int idProduct = resultSet.getInt("product_id");
                String nameProduct = resultSet.getString("product_name");
                double priceProduct = resultSet.getDouble("product_price");
                String image = resultSet.getString("product_image");
                int idDetailOrder = resultSet.getInt("detail_order_id");
                int quality = resultSet.getInt("quality");
                User user = new User(idUser,nameUser);
                StatusOrder statusOrder = new StatusOrder(idStatus,nameStatus);
                Order order = new Order(idOrder,orderDate,comment,address,user,statusOrder);
                Product product = new Product(idProduct,nameProduct,priceProduct,image);
                DetailOrder detailOrder = new DetailOrder(idDetailOrder,quality,order,product);
                detailOrderList.add(detailOrder);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return detailOrderList;
    }

    @Override
    public Order order(int id) {
        Connection connection = baseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(FIND_BY_ID);
            callableStatement.setInt(1,id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int idOrder = resultSet.getInt("order_id");
                int idUser = resultSet.getInt("user_id");
                String nameUser = resultSet.getString("user_name");
                int idStatus = resultSet.getInt("id");
                User user = new User(idUser,nameUser);
                StatusOrder statusOrder = new StatusOrder(idStatus);
                Order order = new Order(idOrder,user,statusOrder);
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean editOrder(int idOrder, int idStatus) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS_ORDER);
            preparedStatement.setInt(1,idStatus);
            preparedStatement.setInt(2,idOrder);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    @Override
    public boolean deleteOrder(int id) {
        Connection connection = baseRepository.getConnection();
        try {
            CallableStatement callableStatement =connection.prepareCall(DELETE_ORDER);
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Order> searchOrder(String userName, String status) {
        Connection connection = baseRepository.getConnection();
        List<Order> orders = new ArrayList<>();
        try {
          Statement statement = connection.createStatement();
           ResultSet resultSet =statement.executeQuery(" SELECT o.*,`user`.user_name,sta.name_status FROM `order` as o " +
                    " JOIN detail_order as detail on detail.order_id = o.order_id " +
                    " JOIN product as pro on pro.product_id = detail.order_id " +
                    " JOIN `status` as sta on sta.id = o.id_status " +
                    " JOIN `user` on `user`.user_id = o.user_id " +
                    " where user.user_name like '%"+userName+"%'" +
                    " or sta.name_status like '%"+status+"%'" +
                    " group by o.order_id");
            while(resultSet.next()){
                int idOrder = resultSet.getInt("order_id");
                String orderDate = resultSet.getString("order_date");
                String comment = resultSet.getString("comment");
                String address = resultSet.getString("address");
                int idUser = resultSet.getInt("user_id");
                String nameUser = resultSet.getString("user_name");
                int idStatus = resultSet.getInt("id_status");
                String nameStatus = resultSet.getString("name_status");
                StatusOrder statusOrder =new StatusOrder(idStatus,nameStatus);
                User user = new User(idUser,nameUser);
                orders.add(new Order(idOrder,orderDate,comment,address,user,statusOrder));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }
}
