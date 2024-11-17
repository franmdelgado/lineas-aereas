package util;

import entities.Vuelo;
import model.ShortestPathResponse;
import service.GestorVuelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Grafo {
    private final Map<String, List<Arista>> adyacencia;

    public Grafo() {
        this.adyacencia = new HashMap<>();
    }

    private void addVertice(String vertice) {
        adyacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    public void addArista(String origen, String destino, int peso) {
        addVertice(origen);
        addVertice(destino);
        adyacencia.get(origen).add(new Arista(destino, peso));
    }

    public List<Arista> getVecinos(String vertice) {
        return adyacencia.getOrDefault(vertice, Collections.emptyList());
    }

    public ShortestPathResponse getShortestPath(String origen, String destino){
        //almacena distancia minima acumulada desde el vertice origen - key:vertice , value:distancia
        Map<String, Float> distancias = new HashMap<>();

        //almacena el vertice previo en el camino mas corto hacia un vertice  - key:vertice , value:vertice previo
        Map<String, String> predecesores = new HashMap<>();

        //vertices ya procesados completamente
        List<String> visitados = new ArrayList<>();

        //vertices pendientes de procesar completamente
        List<String> porVisitar = new ArrayList<>();

        for (String vertice : adyacencia.keySet())
            distancias.put(vertice, Float.MAX_VALUE);

        distancias.put(origen, 0f);
        porVisitar.add(origen);

        while (!porVisitar.isEmpty()) {
            String actual = null;
            for (String vertice : porVisitar) {
                if (actual == null || distancias.get(vertice) < distancias.get(actual))
                    actual = vertice;
            }

            porVisitar.remove(actual);
            visitados.add(actual);

            // Si hemos llegado al destino, terminamos
            if (actual.equals(destino)) break;

            // Relajación de las aristas
            for (Arista vecino : getVecinos(actual)) {
                if (visitados.contains(vecino.getDestino())) continue;

                Optional<Vuelo> v = GestorVuelos.getInstance().findFlight(actual, vecino.getDestino());
                float peso = v.isPresent() ? v.get().getPrice() : vecino.getPeso();
                float nuevaDistancia = distancias.get(actual) + peso;

                if (nuevaDistancia < distancias.get(vecino.getDestino())) {
                    distancias.put(vecino.getDestino(), nuevaDistancia);
                    predecesores.put(vecino.getDestino(), actual);
                    if (!porVisitar.contains(vecino.getDestino())) {
                        porVisitar.add(vecino.getDestino());
                    }
                }
            }
        }

        // Reconstrucción del camino más corto
        ShortestPathResponse response = new ShortestPathResponse();
        List<String> camino = new ArrayList<>();
        String paso = destino;
        if (!predecesores.containsKey(paso) && !origen.equals(destino)) {
            System.out.println("No hay un camino desde " + origen + " hasta " + destino);
            return response;
        }
        while (paso != null) {
            camino.add(paso);
            paso = predecesores.get(paso);
        }
        Collections.reverse(camino);

        response.setPath(camino);
        response.setTotalCost(distancias.get(destino));
        return response;
    }

    public void imprimirGrafo() {
        for (String vertice : adyacencia.keySet()) {
            System.out.print(vertice + " -> ");
            for (Arista arista : adyacencia.get(vertice)) {
                System.out.print("(" + arista.getDestino() + ", peso: " + arista.getPeso() + ") ");
            }
            System.out.println();
        }
    }
}