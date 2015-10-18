package pl.bal.konrad.wybory2015.sejm;

import java.util.List;

import pl.bal.konrad.wybory2015.sejm.model.Candidate;
import pl.bal.konrad.wybory2015.sejm.model.Lists;

public class App {

	public static void main(String args[]) {
		DataSource ds = new DataSource("sejm.csv");

		List<Candidate> pisCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.PiS) && c.isFemale());
		List<Candidate> poCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.PO) && c.isFemale());
		List<Candidate> razemCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.Razem) && c.isFemale());
		List<Candidate> korwinCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.KORWiN) && c.isFemale());
		List<Candidate> pslCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.PSL) && c.isFemale());
		List<Candidate> zjednoczonaLewicaCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.ZjednoczonaLewica) && c.isFemale());
		List<Candidate> kukizCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.Kukiz) && c.isFemale());
		List<Candidate> nowoczesnaCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.Nowoczesna) && c.isFemale());
		List<Candidate> jowBezpartyjniCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.JOWBezpartyjni) && c.isFemale());
		List<Candidate> stonogaCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.Stonoga) && c.isFemale());
		List<Candidate> ruchSpolecznyRPCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.RuchSsolecznyRP) && c.isFemale());
		List<Candidate> zjednoczeniDlaSlaskaCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.ZjednoczeniDlaSlaska) && c.isFemale());
		List<Candidate> samoobronaCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.Samoobrona) && c.isFemale());
		List<Candidate> grzegorzBraunSzczescBozeCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.GrzegorzBraunSzczescBoze) && c.isFemale());
		List<Candidate> kongresNowejPrawicyCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.KongresNowejPrawicy) && c.isFemale());
		List<Candidate> mniejszoscNiemieckaCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.MiejszoscNiemiecka) && c.isFemale());
		List<Candidate> obywateleDoParlamentuCandidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(Lists.ObywateleDoParlamentu) && c.isFemale());

		int i =0;
		for (Candidate candidate : pisCandidates) {
			i++;
			System.out.println(i+ ". " +candidate);
		}
		System.out.println("\nIlość kandydatek z danej listy: " + pisCandidates.size());

	}
}
