import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PicosSensor {

	public static void main(String[] args) {

		List<Integer> dadosIniciais = new ArrayList<>();

		dadosIniciais.add(50);
		dadosIniciais.add(70);
		dadosIniciais.add(56);
		dadosIniciais.add(70);
		dadosIniciais.add(75); // posicao 4
		dadosIniciais.add(56);
		dadosIniciais.add(40);
		dadosIniciais.add(50);
		dadosIniciais.add(70);
		dadosIniciais.add(56);
		dadosIniciais.add(70);
		dadosIniciais.add(80); // posicao 11
		dadosIniciais.add(56);
		dadosIniciais.add(40);
		dadosIniciais.add(50);
		dadosIniciais.add(70); // posicao 15
		dadosIniciais.add(56);
		dadosIniciais.add(70);

		Integer maiorPico = 0;

		List<Integer> indexMaiorPicos = new ArrayList<>();
		List<Integer> indexBaterMenosQue50 = new ArrayList<>();

		Integer posicaoDeMaiorValor = null;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < dadosIniciais.size(); i++) {

			if (dadosIniciais.get(i) > maiorPico) {
				maiorPico = dadosIniciais.get(i);
				posicaoDeMaiorValor = i;
			}

			if (dadosIniciais.get(i) < 50) {
				indexBaterMenosQue50.add(i);
				map.put(maiorPico, posicaoDeMaiorValor);
				maiorPico = 0;
			}

			if (i == dadosIniciais.size() - 1) {
				map.put(maiorPico, posicaoDeMaiorValor);
			}

		}

		System.out.println(map);

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();

			indexMaiorPicos.add(value);
		}

		indexMaiorPicos.sort(Collections.reverseOrder());

		System.out.println(indexMaiorPicos);

		List<Integer> finalLista = new ArrayList<>();
		for (int i = 0; i < indexMaiorPicos.size(); i++) {
			if ((i + 1) != indexMaiorPicos.size()) {
				Integer x = indexMaiorPicos.get(i) - indexMaiorPicos.get(i + 1);
				finalLista.add(x);
			}
		}

		Integer finalSoma = 0;
		for (int i = 0; i < finalLista.size(); i++) {
			finalSoma += finalLista.get(i);
		}

		Integer finalSomaFinal = finalSoma / finalLista.size();

		System.out.println(finalSomaFinal);
	}

}