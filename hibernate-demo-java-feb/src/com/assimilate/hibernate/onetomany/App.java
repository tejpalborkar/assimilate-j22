package com.assimilate.hibernate.onetomany;

import java.util.Date;

import org.hibernate.Session;

import com.assimilate.hibernate.HibernateUtil;

public class App {
	public static void main(String[] args) {

		System.out.println("Hibernate one to many (Annotation)");
		Session session = com.assimilate.hibernate.HibernateUtil.getSession();

		session.beginTransaction();

		Stock stock = new Stock();
		stock.setStockCode("7052");
		stock.setStockName("HDFC");

		StockDailyRecord stockDailyRecords = new StockDailyRecord();
		stockDailyRecords.setPriceOpen(new Float("1.2"));
		stockDailyRecords.setPriceClose(new Float("1.1"));
		stockDailyRecords.setPriceChange(new Float("10.0"));
		stockDailyRecords.setVolume(3000000L);
		stockDailyRecords.setDate(new Date());
		
		
		StockDailyRecord stockDailyRecords2 = new StockDailyRecord();
		stockDailyRecords2.setPriceOpen(new Float("1.2"));
		stockDailyRecords2.setPriceClose(new Float("1.1"));
		stockDailyRecords2.setPriceChange(new Float("10.0"));
		stockDailyRecords2.setVolume(3000000L);
		stockDailyRecords2.setDate(new Date(2020, 8,1));
		
//		stockDailyRecords2.setStock(stock);
		
		stock.getStockDailyRecords().add(stockDailyRecords);
		stock.getStockDailyRecords().add(stockDailyRecords2);

		session.saveOrUpdate(stock);
//		session.save(stockDailyRecords);
//		session.save(stockDailyRecords2);

		session.getTransaction().commit();
		System.out.println("Done");
		session.close();
		session = HibernateUtil.getSession();
		
		Stock stockFromDb =session.get(Stock.class,1);
		System.out.println(stockFromDb);
		System.out.println(stockFromDb.getStockDailyRecords());
		
		session.delete(stockFromDb);
		
		
		session.beginTransaction().commit();
		
		System.out.println("stock deleted");
	}
}