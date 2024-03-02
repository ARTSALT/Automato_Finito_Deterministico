# Trabalho de Linguagens Formais e Autômatos
 - Este trabalho se refere a cadeira de LFA da UFERSA (Universidade Federal Rural do Semiárido)
 - No momento o trabalho incluí apenas autômatos finitos determinísticos, mas futuramente pode receber atualizalções incluindo outros tipos de autômatos.

 # Sobre o Funcionamento
 - A maior parte do código é feito de requisições para o usuário sobre os dados do autômato.
 - A parte do código que realmente faz o autômato funcionar opera similarmente a uma lista simples ligada (referência apenas o próximo elemento), mas com um array de referências ao invés de uma única, essas referências possuem uma entrada (caracter) e uma saída (próximo estado).

 # Sobre o Uso
 - O programa funciona no terminal de comandos, basta executar o arquivo Main.java na pasta src/afd/main.java
 - Ao iniciar o programa serão pedidas as informações do autômato na seguinte ordem:
  - Tamanho do alfabeto e símbolos contidos nele;
  - Número de Estados e seus nomes;
  - Números e quais são os estados finais;
  - Labels das transições.
 - Por fim, basta informar a cadeia e será retornada a resposta se ela foi aceita ou não.
