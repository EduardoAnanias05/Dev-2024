# # Exercicio 01  
# from functools import update_wrapper


# a = float (input("Digite o Valor de A: "))
# b = float (input("Digite o Valor de B: "))

# raio = float (input("Digite o Valor de do Raio: "))


# soma = a + b 
# Subtração = a - b
# Multiplicação = a * b
# Divisão = a / b
# DivisãoInteira = a // b
# RestodaDivisão = a % b
# Potenciação = a ** b


# print(f" A divisão da soma é: {soma} "  )  
# print(Subtração )
# print(Multiplicação) 
# print(Divisão )
# print(DivisãoInteira) 
# print(RestodaDivisão ) 
# print(Potenciação )

# área = 3.14 * raio**2  

# print(área)

# # Exercicio 02  

# nome = "Eduardo" 
# sobrenome = "Ananias" 

# # Aspas duplas para dar "Espaço no nome"
# print(nome + " " + sobrenome)  


# Deixando Frase min ou mai 
Frase = "Comi o cu do Luigi Sousa"  

FraseMai = Frase.upper() 

FraseMin = Frase.lower()

print((f"A Frase maiúscula é: {FraseMai}")) 
print((f"A Frase minúscula é: {FraseMin}")) 

palavra1 = str(input("Digite a palavra a ser retirada: "))

palavra2 = str(input("Digite a palavra que irá substituir a anterior: "))

subs = Frase.replace(palavra1, palavra2)


print(f"A nova frase é: {subs}")

