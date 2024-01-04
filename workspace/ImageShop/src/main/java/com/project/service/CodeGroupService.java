package com.project.service;

import java.util.List;

import com.project.domain.CodeGroup;

public interface CodeGroupService {
	// 등록 처리
	public void register(CodeGroup codeGroup) throws Exception;
	// 목록 페이지
	public List<CodeGroup> list() throws Exception;
	// 상세 페이지
	public Object read(String groupCode) throws Exception;

}
