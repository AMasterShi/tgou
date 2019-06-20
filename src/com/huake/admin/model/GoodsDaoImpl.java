package com.huake.admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.huake.pojo.Goods;
import com.huake.util.JdbcUtil;

public class GoodsDaoImpl {
	/* 查询商品信息 */
	public ArrayList<Goods> findAllGoods() {
		Connection connection = null;
		ArrayList<Goods> glist = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = JdbcUtil.newInstance().getConnection();
			String sql = "select * from goods";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			Goods goods = null;
			while(rs.next()) {
				goods = new Goods(rs.getInt("id"),rs.getString("title"),rs.getInt("oldMoney"),rs.getInt("money"),rs.getString("goodNumber"),rs.getString("goodIntroduction"),rs.getString("sellNumber"),rs.getInt("newgoods"),rs.getInt("sellwell"),rs.getString("images"));
				glist.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return glist;
	}
	/* 修改商品信息 */
	public int modifyGoods(Goods oldGoods) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = JdbcUtil.newInstance().getConnection();
			String sql = "update goods set title=?,oldMoney=?,money=?,goodNumber=?,goodIntroduction=?,sellNumber=?,newgoods=?,sellwell=?,images=? where id=?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, oldGoods.getTitle());
			ps.setInt(2, oldGoods.getOldMoney());
			ps.setInt(3, oldGoods.getMoney());
			ps.setString(4, oldGoods.getGoodNumber());
			ps.setString(5, oldGoods.getGoodIntroduction());
			ps.setString(6, oldGoods.getSellNumber());
			ps.setInt(7, oldGoods.getNewgoods());
			ps.setInt(8, oldGoods.getSellwell());
			ps.setString(9, oldGoods.getImages());
			ps.setInt(10, oldGoods.getId());
			int i = ps.executeUpdate();
			if(i > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/* 查询指定商品信息 */
	public Goods findOneGoods(int goods_id) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Goods goods = null;
		try {
			connection = JdbcUtil.newInstance().getConnection();
			String sql = "select * from goods where id = ?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, goods_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				goods = new Goods(rs.getInt("id"),rs.getString("title"),rs.getInt("oldMoney"),rs.getInt("money"),rs.getString("goodNumber"),rs.getString("goodIntroduction"),rs.getString("sellNumber"),rs.getInt("newgoods"),rs.getInt("sellwell"),rs.getString("images"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}
	/* 删除商品信息 */
	public int deleteGoods(int goods_id) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = JdbcUtil.newInstance().getConnection();
			String sql = "delete from goods where id = ?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, goods_id);
			int i = ps.executeUpdate();
			if(i > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/* 添加商品信息 */
	public int addGoods(Goods goods) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = JdbcUtil.newInstance().getConnection();
			String sql = "insert into goods(title,oldMoney,money,goodNumber,goodIntroduction,sellNumber,newgoods,sellwell,images) values(?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, goods.getTitle());
			ps.setInt(2, goods.getOldMoney());
			ps.setInt(3, goods.getMoney());
			ps.setString(4, goods.getGoodNumber());
			ps.setString(5, goods.getGoodIntroduction());
			ps.setString(6, goods.getSellNumber());
			ps.setInt(7, goods.getNewgoods());
			ps.setInt(8, goods.getSellwell());
			ps.setString(9, goods.getImages());
			int i = ps.executeUpdate();
			if(i > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/* 商品编号的模糊搜索 */
	public ArrayList<Goods> likeGoodsBynum(String goodNumber) {
		Connection connection = null;
		ArrayList<Goods> glist = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = JdbcUtil.newInstance().getConnection();
			String sql = "select * from goods where goodNumber like ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, goodNumber+"%");
			rs = ps.executeQuery();
			Goods goods = null;
			while(rs.next()) {
				goods = new Goods(rs.getInt("id"),rs.getString("title"),rs.getInt("oldMoney"),rs.getInt("money"),rs.getString("goodNumber"),rs.getString("goodIntroduction"),rs.getString("sellNumber"),rs.getInt("newgoods"),rs.getInt("sellwell"),rs.getString("images"));
				glist.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return glist;
	}
	
	public ArrayList<Goods> likeGoodsBytitle(String title) {
		Connection connection = null;
		ArrayList<Goods> glist = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = JdbcUtil.newInstance().getConnection();
			String sql = "select * from goods where title like ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%"+title+"%");
			rs = ps.executeQuery();
			Goods goods = null;
			while(rs.next()) {
				goods = new Goods(rs.getInt("id"),rs.getString("title"),rs.getInt("oldMoney"),rs.getInt("money"),rs.getString("goodNumber"),rs.getString("goodIntroduction"),rs.getString("sellNumber"),rs.getInt("newgoods"),rs.getInt("sellwell"),rs.getString("images"));
				glist.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return glist;
	}
	
	public ArrayList<Goods> likeGoods(String goodNumber, String title) {
		Connection connection = null;
		ArrayList<Goods> glist = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = JdbcUtil.newInstance().getConnection();
			String sql = "select * from goods where goodNumber like ? and title like ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, goodNumber+"%");
			ps.setString(2, "%"+title+"%");
			rs = ps.executeQuery();
			Goods goods = null;
			while(rs.next()) {
				goods = new Goods(rs.getInt("id"),rs.getString("title"),rs.getInt("oldMoney"),rs.getInt("money"),rs.getString("goodNumber"),rs.getString("goodIntroduction"),rs.getString("sellNumber"),rs.getInt("newgoods"),rs.getInt("sellwell"),rs.getString("images"));
				glist.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return glist;
	}
}
