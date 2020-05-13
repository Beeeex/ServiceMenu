package com.example.entites;

import java.io.Serializable;
import java.util.List;

public class MenuNode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer depth;
	private Integer nodeId;
	private String nodeName;
	private String nodeType;
	private String groupType;
	private String status;
	private String flowType;
	private Long startValidityTs;
	private Long endValidityTs;
	private List<MenuNode> nodes;
	private Resource resource;



	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	} 
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getStartValidityTs() {
		return startValidityTs;
	}
	public void setStartValidityTs(Long startValidityTs) {
		this.startValidityTs = startValidityTs;
	}
	public Long getEndValidityTs() {
		return endValidityTs;
	}
	public void setEndValidityTs(Long endValidityTs) {
		this.endValidityTs = endValidityTs;
	}
	public List<MenuNode> getNodes() {
		return nodes;
	}
	public void setNodes(List<MenuNode> nodes) {
		this.nodes = nodes;
	}

	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public String getFlowType() {
		return flowType;
	}
	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
}

 
 
 
 
 

