USE [Reporting_Colombia]
GO
/****** Object:  Table [dbo].[Agrupacion_mensual_turnos]    Script Date: 07/05/2017 19:03:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Agrupacion_mensual_turnos](
	[fecha] [date] NULL,
	[Windows] [varchar](50) NULL,
	[Ingreso Planificado] [varchar](5) NOT NULL,
	[Hora de conexión] [time](0) NOT NULL,
	[Egreso Planificado] [varchar](5) NOT NULL,
	[Hora de Desconex] [time](2) NOT NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Agrupacion_mensual_Adherencia]    Script Date: 07/05/2017 19:03:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Agrupacion_mensual_Adherencia](
	[leg] [float] NOT NULL,
	[Agente] [varchar](250) NULL,
	[Windows] [varchar](50) NULL,
	[Retardos] [decimal](38, 2) NULL,
	[TIEMPO_LOGUEO_REAL] [decimal](38, 2) NULL,
	[horas_planificadas] [decimal](38, 2) NULL,
	[Tiempo_de_mas] [decimal](38, 2) NULL,
	[horas_turno_programado] [decimal](38, 2) NULL,
	[LLegadas_tarde] [int] NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
