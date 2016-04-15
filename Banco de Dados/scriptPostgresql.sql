CREATE TABLE Endereco (
  idEndereco SERIAL NOT NULL,
  logradouro VARCHAR(100) NOT NULL,
  bairro VARCHAR(100) NOT NULL,
  numero INTEGER NOT NULL,
  CEP VARCHAR(15) NULL,
  complemento VARCHAR(100) NULL,
  PRIMARY KEY(idEndereco)
);

CREATE TABLE Usuario (
  idUsuario SERIAL NOT NULL,
  login VARCHAR(20) NULL,
  senha VARCHAR(20) NULL,
  dataNasc DATE NULL,
  nome VARCHAR(100) NULL,
  telefone VARCHAR(20) NULL,
  email VARCHAR(100) NULL,
  PRIMARY KEY(idUsuario),
  idEndereco INTEGER REFERENCES Endereco (idEndereco) ON UPDATE CASCADE ON DELETE CASCADE
);
  
CREATE TABLE Administrador (
  idAdministrador Serial NOT NULL ,
  Usuario_idUsuario INT NOT NULL,
  PRIMARY KEY(idAdministrador),
  idUsuario INTEGER REFERENCES Usuario (idUsuario) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Medico (
  idMedico SERIAL NOT NULL,
  CRM INTEGER NULL,
  PRIMARY KEY(idMedico),
  idUsuario INTEGER REFERENCES Usuario (idUsuario) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Especialidade (
  idEspecialidade SERIAL NOT NULL,
  nome VARCHAR(80) NULL,
  PRIMARY KEY(idEspecialidade)
);

CREATE TABLE Medico_Especialidade (
  idEspecialidade INTEGER REFERENCES Especialidade (idEspecialidade) ON UPDATE CASCADE ON DELETE CASCADE,
  idMedico INTEGER REFERENCES Medico (idMedico) ON UPDATE CASCADE ON DELETE CASCADE,
  PRIMARY KEY (idEspecialidade, idMedico)
);

CREATE TABLE Secretario (
  idSecretario SERIAL NOT NULL,
  turno INTEGER NULL,
  PRIMARY KEY(idSecretario),
  idUsuario INTEGER REFERENCES Usuario (idUsuario) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Paciente (
  idPaciente SERIAL NOT NULL,
  nome VARCHAR(100) NULL,
  telefone VARCHAR(20) NULL,
  cpf VARCHAR(20) NULL,
  email VARCHAR(100) NULL,
  sexo CHAR NULL,
  dataNasc DATE NULL,
  PRIMARY KEY(idPaciente),
  idEndereco INTEGER REFERENCES Endereco (idEndereco) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Pagamento (
  idPagamento SERIAL NOT NULL,
  valor FLOAT NULL,
  tipoPagamento CHAR NULL,
  PRIMARY KEY(idPagamento)
);

CREATE TABLE Consulta (
  idConsulta SERIAL NOT NULL,
  dataConsulta DATE NOT NULL,
  horarioConsulta TIME NOT NULL,
  motivo VARCHAR NOT NULL,
  PRIMARY KEY(idConsulta),
  idMedico INTEGER REFERENCES Medico (idMedico) ON UPDATE CASCADE ON DELETE CASCADE,
  idPaciente INTEGER REFERENCES Paciente (idPaciente) ON UPDATE CASCADE ON DELETE CASCADE,
  idPagamento INTEGER REFERENCES Pagamento (idPagamento) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE DadosConsulta (
  idRelatorio SERIAL NOT NULL,
  dataRegistro DATE NULL,
  horarioRegistro TIME NULL,
  descricao VARCHAR NULL,
  PRIMARY KEY(idRelatorio),
  idConsulta INTEGER REFERENCES Consulta (idConsulta) ON UPDATE CASCADE ON DELETE CASCADE
);
  
  