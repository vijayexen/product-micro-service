package com.perficient.cloud.products.model;

public class Product {

	private Long id;
	private String name;
	private String transport;
	private String bandwidth;
	private String router;
	private String buildingExtn;
	private Price price;
	private Error error;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(String bandwidth) {
		this.bandwidth = bandwidth;
	}

	public String getRouter() {
		return router;
	}

	public void setRouter(String router) {
		this.router = router;
	}

	public String getBuildingExtn() {
		return buildingExtn;
	}

	public void setBuildingExtn(String buildingExtn) {
		this.buildingExtn = buildingExtn;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

}
