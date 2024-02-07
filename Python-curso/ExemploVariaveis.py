


# 4. Dicionários:

# Dicionário chave-valor
pessoa = {
    "nome": "Carlos",
    "idade": 30,
    "profissao": "engenheiro"
}

# Acessando valores
# print(pessoa["nome"])
# print(pessoa.get("idade"))
# print(pessoa.get("profissao"))

# Adicionando novo par chave-valor
pessoa["cidade"] = "São Paulo"

# 5. Booleans:


# Variáveis booleanas
tem_cafe = True
tem_cha = False

# Expressões booleanas
tem_bebida_quente = tem_cafe or tem_cha
tem_os_dois = tem_cafe and tem_cha

# Operações Matemáticas:
# Números
a = 10
b = 3

# Soma
soma = a + b

# Subtração
subtracao = a - b

# Multiplicação
multiplicacao = a * b

# Divisão
divisao = a / b

# Resultados
print(soma, subtracao, multiplicacao, divisao)

frase = "Python é uma linguagem poderosa"

# Extrair as primeiras 6 letras
primeiras_letras = frase[:6]

# Extrair as últimas 9 letras
ultimas_letras = frase[-9:]

# Extrair cada segunda letra
cada_segunda_letra = frase[::2]

print(primeiras_letras, ultimas_letras, cada_segunda_letra)

# 2. Formatação Avançada:

nome = "João"
idade = 30

# Usando f-strings
mensagem = f"Olá, {nome}! Você tem {idade} anos."

# Usando método format
outra_mensagem = "Olá, {}! Você tem {} anos.".format(nome, idade)

print(mensagem)
print(outra_mensagem)

# 3. Métodos Adicionais:

texto = "   Python é incrível!   "

# Remover espaços em branco no início e no final
texto_trim = texto.strip()

# Converter para letras maiúsculas
texto_upper = texto.upper()

# Substituir parte do texto
texto_substituido = texto.replace("Python", "Java")

# Dividir a string em uma lista de palavras
lista_palavras = texto.split()

print(texto_trim)
print(texto_upper)
print(texto_substituido)
print(lista_palavras)

# 4. Verificação e Manipulação:

email = "usuario@email.com"

# Verificar se a string é um e-mail
e_email = email.endswith(".com")

# Contar o número de ocorrências de uma letra
contagem_letra = texto.count("o")

# Encontrar a posição da palavra "incrível"
posicao_incrivel = texto.find("incrível")

print(e_email)
print(contagem_letra)
print(posicao_incrivel)

# 5. Concatenação:

nome = "Maria"
sobrenome = "Silva"

# Concatenar strings usando o operador '+'
nome_completo = nome + " " + sobrenome

# Concatenar usando o método join
lista_palavras = ["Python", "é", "incrível"]
frase_completa = " ".join(lista_palavras)

print(nome_completo)
print(frase_completa)



idade = 18
if idade >= 18:
    pode_votar = True
else:
    pode_votar = False

print(pode_votar) 

# Tipagem 

numero = "42 "
texto = "Python"
resultado = numero+texto 

print(resultado)

