package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.CodeGroup;
import com.project.mapper.CodeGroupMapper;

@Service
public class CodeGroupServiceImpl implements CodeGroupService {
	
	@Autowired
	private CodeGroupMapper mapper;

	@Override // 등록 처리
	public void register(CodeGroup codeGroup) throws Exception {
		mapper.create(codeGroup);
	}

	@Override // 목록 페이지
	public List<CodeGroup> list() throws Exception {
		return mapper.list();
	}

	@Override // 상세 페이지
	public CodeGroup read(String groupCode) throws Exception {
		 return mapper.read(groupCode);
	}
}
