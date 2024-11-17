package util;

public class ArbolAVL {
    private NodoAVL raiz;

    private int getHeight(NodoAVL nodo) {
        return nodo == null ? 0 : nodo.getHeight();
    }

    private int getBalanceFactor(NodoAVL nodo) {
        return nodo == null ? 0 : getHeight(nodo.getLeft()) - getHeight(nodo.getRight());
    }

    private NodoAVL rightRotation(NodoAVL y) {
        NodoAVL x = y.getLeft();
        NodoAVL subtree = x.getRight();

        x.setRight(y);
        y.setLeft(subtree);

        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);
        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);

        return x;
    }

    private NodoAVL leftRotation(NodoAVL x) {
        NodoAVL y = x.getRight();
        NodoAVL subTree = y.getLeft();

        y.setLeft(x);
        x.setRight(subTree);

        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);

        return y;
    }

    private NodoAVL put(NodoAVL nodoBase, NodoAVL nodoValue) {
        if (nodoBase == null) {
            return nodoValue;
        }

        if (nodoValue.getSeat() < nodoBase.getSeat()) {
            nodoBase.setLeft(put(nodoBase.getLeft(), nodoValue));
        } else if (nodoValue.getSeat() > nodoBase.getSeat()) {
            nodoBase.setRight(put(nodoBase.getRight(), nodoValue));
        } else {
            return nodoBase;
        }

        nodoBase.setHeight(1 + Math.max(getHeight(nodoBase.getLeft()), getHeight(nodoBase.getRight())));

        int balance = getBalanceFactor(nodoBase);

        if (balance > 1 && nodoValue.getSeat() < nodoBase.getLeft().getSeat()) {
            return rightRotation(nodoBase);
        }

        if (balance < -1 && nodoValue.getSeat() > nodoBase.getRight().getSeat()) {
            return leftRotation(nodoBase);
        }

        if (balance > 1 && nodoValue.getSeat() > nodoBase.getLeft().getSeat()) {
            nodoBase.setLeft(leftRotation(nodoBase.getLeft()));
            return rightRotation(nodoBase);
        }

        if (balance < -1 && nodoValue.getSeat() < nodoBase.getRight().getSeat()) {
            nodoBase.setRight(rightRotation(nodoBase.getRight()));
            return leftRotation(nodoBase);
        }

        return nodoBase;
    }

    public void put(NodoAVL node) {
        raiz = put(raiz, node);
    }

    private void inOrden(NodoAVL nodo) {
        if (nodo != null) {
            inOrden(nodo.getLeft());
            System.out.println("Asiento: " + nodo.getSeat() + ": " + nodo.getTripulante());
            inOrden(nodo.getRight());
        }
    }

    public void inOrden() {
        inOrden(raiz);
    }
}
