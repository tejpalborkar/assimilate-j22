package com.assimilate.hibernate.onetomany;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock_daily_record", uniqueConstraints = @UniqueConstraint(columnNames = "DATE"))
public class StockDailyRecord {

	private Integer recordId;
	private Float priceOpen;
	private Float priceClose;
	private Float priceChange;
	private Long volume;
	private Date date;

	public StockDailyRecord() {
	}

	public StockDailyRecord(Stock stock, Date date) {
		this.date = date;
	}

	public StockDailyRecord(Stock stock, Float priceOpen, Float priceClose, Float priceChange, Long volume, Date date) {
		this.priceOpen = priceOpen;
		this.priceClose = priceClose;
		this.priceChange = priceChange;
		this.volume = volume;
		this.date = date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECORD_ID", unique = true, nullable = false)
	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	@Column(name = "PRICE_OPEN", precision = 6)
	public Float getPriceOpen() {
		return this.priceOpen;
	}

	public void setPriceOpen(Float priceOpen) {
		this.priceOpen = priceOpen;
	}

	@Column(name = "PRICE_CLOSE", precision = 6)
	public Float getPriceClose() {
		return this.priceClose;
	}

	public void setPriceClose(Float priceClose) {
		this.priceClose = priceClose;
	}

	@Column(name = "PRICE_CHANGE", precision = 6)
	public Float getPriceChange() {
		return this.priceChange;
	}

	public void setPriceChange(Float priceChange) {
		this.priceChange = priceChange;
	}

	@Column(name = "VOLUME")
	public Long getVolume() {
		return this.volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", unique = true, nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "StockDailyRecord [recordId=" + recordId + ", priceOpen=" + priceOpen + ", priceClose=" + priceClose
				+ ", priceChange=" + priceChange + ", volume=" + volume + ", date=" + date + "]";
	}

}
