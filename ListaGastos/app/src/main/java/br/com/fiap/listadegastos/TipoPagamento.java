package br.com.fiap.listadegastos;

enum TipoPagamento {
    DINHEIRO{
        @Override
        public String toString() {
            return "Dinheiro";
        }
    },

    CARTAO {
        @Override
        public String toString() {
            return "CARTAO";
        }
    },
    ;
}
