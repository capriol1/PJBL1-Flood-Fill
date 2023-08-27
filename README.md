# PJBL1 Flood Fill
Trabalho Estrutura de Dados

Nesta implementação, a função floodFill recebe a matriz de imagem, as coordenadas iniciais startX e startY e realiza o preenchimento de inundação. O algoritmo utiliza uma fila para armazenar os pixels a serem processados. A cor de fundo é armazenada na variável targetColor, e o novo valor de cor é definido como NEW_COLOR.

O algoritmo continua a executar enquanto a fila não estiver vazia. A cada iteração, um pixel é removido da fila e suas coordenadas são calculadas. Se o pixel estiver fora dos limites da matriz ou não tiver a cor de fundo, ele é ignorado. Caso contrário, o pixel é preenchido com a nova cor e seus vizinhos são adicionados à fila para processamento posterior.
No exemplo fornecido, a função main cria uma matriz de imagem e chama a função floodFill com as coordenadas iniciais (7, 8). Em seguida, imprime a matriz resultante no console.
