package com.impact.task;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CandidateStreamingOperations {

	public static void main(String[] args) {

		List<Candidate> candidateList = InterviewRepository.getCandidateList();

		// list candidate names from Pune city
		System.out.println("List of Pune Candidates:");
		List<String> puneCandidate = candidateList.stream().filter(candidate -> candidate.getCity().equals("Pune"))
				.map(candidate -> candidate.getName()).collect(Collectors.toList());
		System.out.println(puneCandidate);
		printLine();

		// list city and count of candidates per city
		System.out.println("Candidate count per city");
		candidateList.stream().map(cand -> cand.getCity())
				.collect(Collectors.groupingBy(Function.identity(), (HashMap::new), Collectors.counting())).entrySet()
				.forEach(map -> System.out.println(map.getKey() + " : " + map.getValue()));
		printLine();

		// list technical expertise and count of candidates
		System.out.println("Candidate count by Technical Expertise");
		candidateList.stream().map(cand -> cand.getTechnicalExpertise())
				.collect(Collectors.groupingBy(Function.identity(), (HashMap::new), Collectors.counting())).entrySet()
				.forEach(map -> System.out.println(map.getKey() + " : " + map.getValue()));
		printLine();

		// list fresher candidates
		System.out.println("Fresher Candidate list");
		candidateList.stream().filter(candidate -> candidate.getYearsOfExperience() == 0).forEach(System.out::println);
		printLine();

		// listing candidates with highest experience
		System.out.println("Sorted List of Candidates by Experience");
		Comparator<Candidate> comparator = (c1, c2) -> c1.getYearsOfExperience() > c2.getYearsOfExperience() ? 1
				: c1.getYearsOfExperience() < c2.getYearsOfExperience() ? -1 : 0;

		int maxExp = candidateList.stream().max(comparator).map(c -> c.getYearsOfExperience()).get();
		candidateList.stream().filter(candidate -> candidate.getYearsOfExperience() == maxExp)
				.forEach(System.out::println);

		// sort the candidates by city name
		printLine();
		System.out.println("Sorted List of Candidates by City Name");
		candidateList.stream().sorted((o1, o2) -> o1.getCity().compareTo(o2.getCity())).forEach(System.out::println);
		
	}

	private static void printLine() {
		// TODO Auto-generated method stub
		System.out.println("======================================================");
	}

}
