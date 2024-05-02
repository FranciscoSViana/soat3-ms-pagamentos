# language: pt
Funcionalidade: API - Pagamentos

  Cenário: Criação de pagamento
    Dado um pagamento é solicitado
    Quando o endpoint de criação de pagamento é chamado
    Então o pagamento é criado com sucesso
