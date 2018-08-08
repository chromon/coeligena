package com.coeligena.function.vote;


import com.coeligena.dto.AnswersDTO;

import java.util.Comparator;

public class VoteComparator implements Comparator<AnswersDTO> {

	@Override
	public int compare(AnswersDTO o1, AnswersDTO o2) {
		
		int flag = o1.getAnswerWeight().compareTo(o2.getAnswerWeight());
		
		// 权重相等时按时间排序
		if(flag == 0) {
			return o1.getAnswersDO().getAnswerTime()
					.compareTo(o2.getAnswersDO().getAnswerTime());
		}
		
		// 倒序
		if(flag > 0) {
			flag = -1;
		} else {
			flag = 1;
		}
		
		return flag;
	}



}
