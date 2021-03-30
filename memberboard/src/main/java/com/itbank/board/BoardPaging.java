package com.itbank.board;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component				// �̰� ��Ʈ�ѷ��� �ƴϰ�, ���񽺵� �ƴϰ�, �������͸��� �ƴ����� ��·�� ������ ������ ��޶�
@Scope("prototype")		// ���� ����ڰ� ���Դµ� ���� ����¡ ��ü�� ���� �ȵǴϱ�, �̱����� ������� �ʴ´� !!
public class BoardPaging {
	
	private int page;
	private final int perPage = 10;		// �� ������ �� 10���� ���� ����ϱ�
	private final int perSection = 10;	// �� ȭ�鿡 �ִ� 10���� ������ ��ȣ�� ����ϱ�
	
	private int first;		// ù��° �۹�ȣ
	private int last;		// ������ �۹�ȣ
	private int begin;		// �ϴ� ����¡ ���� ù��°
	private int end;		// �ϴ� ����¡ ���� ������
	private boolean prev;
	private boolean next;

	public void setPage(int boardCount, int page) {
		this.page = page;
		int pageCount = boardCount / perPage;
		pageCount += boardCount % perPage == 0 ? 0 : 1;
		this.first = (page - 1) * perPage + 1;
		this.last = first + perPage - 1;
		
		int section = (page - 1) / 10;
		begin = 10 * section + 1;
		end = begin + perSection - 1 > pageCount ? pageCount : begin + perSection - 1;
		
		setPrev(section != 0);
		setNext(boardCount > perPage * end);
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getPage() {
		return page;
	}

	public boolean hasPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean hasNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
}
