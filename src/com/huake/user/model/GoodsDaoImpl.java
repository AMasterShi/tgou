package com.huake.user.model;

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
				goods = new Goods(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
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
			String sql = "update goods set title=?,oldMoney=?,money=?,goodNumber=?,goodIntroduction=?,sellNumber=?,images=? where id=?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, oldGoods.getTitle());
			ps.setInt(2, oldGoods.getOldMoney());
			ps.setInt(3, oldGoods.getMoney());
			ps.setString(4, oldGoods.getGoodNumber());
			ps.setString(5, oldGoods.getGoodIntroduction());
			ps.setString(6, oldGoods.getSellNumber());
			ps.setString(7, oldGoods.getImages());
			ps.setInt(8, oldGoods.getId());
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
				goods = new Goods(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
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
			String sql = "insert into goods(title,oldMoney,money,goodNumber,goodIntroduction,sellNumber,images) values(?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, goods.getTitle());
			ps.setInt(2, goods.getOldMoney());
			ps.setInt(3, goods.getMoney());
			ps.setString(4, goods.getGoodNumber());
			ps.setString(5, goods.getGoodIntroduction());
			ps.setString(6, goods.getSellNumber());
			ps.setString(7, goods.getImages());
			int i = ps.executeUpdate();
			if(i > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/* 通过价格排序商品 */
	public ArrayList<Goods> orderGoodsBymoney() {
		Connection connection = null;
		ArrayList<Goods> glist = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = JdbcUtil.newInstance().getConnection();
			String sql = "select * from goods order by money";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			Goods goods = null;
			while(rs.next()) {
				goods = new Goods(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				glist.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return glist;
	}
	/* 通过价格降序排序商品 */
	public ArrayList<Goods> orderGoodsBymoneyDESC() {
		Connection connection = null;
		ArrayList<Goods> glist = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = JdbcUtil.newInstance().getConnection();
			String sql = "select * from goods order by money desc";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			Goods goods = null;
			while(rs.next()) {
				goods = new Goods(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				glist.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return glist;
	}
	/* 畅销商品查询 */
	public ArrayList<Goods> sellwellGoods() {
		Connection connection = null;
		ArrayList<Goods> glist = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = JdbcUtil.newInstance().getConnection();
			String sql = "select * from goods where sellwell = 1";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			Goods goods = null;
			while(rs.next()) {
				goods = new Goods(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				glist.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return glist;
	}
	/* 新上市商品查询 */
	public ArrayList<Goods> newGoods() {
		Connection connection = null;
		ArrayList<Goods> glist = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = JdbcUtil.newInstance().getConnection();
			String sql = "select * from goods where newgoods = 1";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			Goods goods = null;
			while(rs.next()) {
				goods = new Goods(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				glist.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return glist;
	}
}
