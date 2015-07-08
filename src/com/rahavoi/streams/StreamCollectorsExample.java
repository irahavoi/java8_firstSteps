package com.rahavoi.streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorsExample {
	public static void main(String[] args){
		StreamCollectorsExample sce = new StreamCollectorsExample();
		Transaction t1 = sce.new Transaction("USD", new BigDecimal(100));
		Transaction t2 = sce.new Transaction("CAD", new BigDecimal(200));
		Transaction t3 = sce.new Transaction("USD", new BigDecimal(300));
		Transaction t4 = sce.new Transaction("CAD", new BigDecimal(400));
		Transaction t5 = sce.new Transaction("USD", new BigDecimal(500));
		Transaction t6 = sce.new Transaction("CAD", new BigDecimal(600));
		
		
		List<Transaction> txList = new ArrayList<StreamCollectorsExample.Transaction>();
		
		txList.add(t1);
		txList.add(t2);
		txList.add(t3);
		txList.add(t4);
		txList.add(t5);
		txList.add(t6);
		
		
		Map<String, List<Transaction>> tMap = 
				txList.stream()
					.collect(Collectors.groupingBy(Transaction::getCurrency));
		
		System.out.println(tMap);
		
		
	}
	
	class Transaction{
		private String currency;
		private BigDecimal amount;
		
		public Transaction(String currency, BigDecimal amount) {
			super();
			this.currency = currency;
			this.amount = amount;
		}

		/**
		 * @return the currency
		 */
		public String getCurrency() {
			return currency;
		}

		/**
		 * @return the amount
		 */
		public BigDecimal getAmount() {
			return amount;
		}
		
		
	}
	

}
