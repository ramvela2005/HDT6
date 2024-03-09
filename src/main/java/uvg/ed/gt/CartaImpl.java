package uvg.ed.gt;

public class CartaImpl implements Carta {
    private final String nombre;
    private final String tipo;

    public CartaImpl(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}

