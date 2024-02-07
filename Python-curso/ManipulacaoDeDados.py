# Manipulação de Strings:

#  1. Slicing: O slicing permite extrair partes específicas de uma string.

frase = "Python é uma linguagem poderosa"

# Extrair as primeiras 6 letras
primeiras_letras = frase[:6]

# Extrair as últimas 9 letras
ultimas_letras = frase[-9:]

# Extrair cada segunda letra
cada_segunda_letra = frase[::2]

print(primeiras_letras, ultimas_letras, cada_segunda_letra)

#  2. Formatação Avançada:

nome = "João"
idade = 30

# Usando f-strings
mensagem = f"Olá, {nome}! Você tem {idade} anos."

# Usando método format
outra_mensagem = "Olá, {}! Você tem {} anos.".format(nome, idade)

print(mensagem)
print(outra_mensagem)

