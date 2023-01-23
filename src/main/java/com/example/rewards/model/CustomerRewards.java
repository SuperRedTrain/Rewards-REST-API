package com.example.rewards.model;
/*
 * Create a model CustomerRewards(customerId, name, lastMonthRewardPoints, lastSecondMonthRewardPoints
 *                        lastThirdMonthRewardPoints, totalRewardPoints)
 */

public class CustomerRewards {
    private Integer customerId;
	private String name;                           // Customer Name
    private Long lastMonthRewardPoints;
    private Long lastSecondMonthRewardPoints;
    private Long lastThirdMonthRewardPoints;
    private Long totalRewardPoints;

    public Integer getCustomerId(){
        return customerId;
    }
    public void setCustomerId(Integer customerId){
        this.customerId = customerId;
    }
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public Long getLastMonthRewardPoints() {
		return lastMonthRewardPoints;
	}
	public void setLastMonthRewardPoints(long lastMonthRewardPoints) {
		this.lastMonthRewardPoints = lastMonthRewardPoints;
	}
	public Long getLastSecondMonthRewardPoints() {
		return lastSecondMonthRewardPoints;
	}
	public void setLastSecondMonthRewardPoints(long lastSecondMonthRewardPoints) {
		this.lastSecondMonthRewardPoints = lastSecondMonthRewardPoints;
	}
	public Long getLastThirdMonthRewardPoints() {
		return lastThirdMonthRewardPoints;
	}
	public void setLastThirdMonthRewardPoints(long lastThirdMonthRewardPoints) {
		this.lastThirdMonthRewardPoints = lastThirdMonthRewardPoints;
	}
    public Long getTotalRewardPoints() {
        return totalRewardPoints;
    }
    public void setTotalRewardPoints(long totalRewardPoints) {
        this.totalRewardPoints = totalRewardPoints;
    }
   
}
