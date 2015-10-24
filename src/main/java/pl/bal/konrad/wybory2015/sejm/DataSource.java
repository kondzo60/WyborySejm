package pl.bal.konrad.wybory2015.sejm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pl.bal.konrad.wybory2015.sejm.model.Candidate;


public class DataSource {
	private List<Candidate> candidatesList;

	public DataSource(String filename) {
		ClassLoader classLoader = Wykres.class.getClassLoader();
		InputStream sejm = classLoader.getResourceAsStream(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(sejm));
		Stream<Candidate> candidates = br.lines().map(Candidate::new);
		candidatesList = candidates.collect(Collectors.<Candidate> toList());
	}

	public List<Candidate> getCandidates() {
		return candidatesList;
	}

	public List<Candidate> getFilteredCandidates(Predicate<Candidate> predicate) {
		return candidatesList.stream().filter(predicate).collect(Collectors.toList());
	}

	public long countFilteredCandidates(Predicate<Candidate> predicate) {
		return candidatesList.stream().filter(predicate).count();
	}
}
