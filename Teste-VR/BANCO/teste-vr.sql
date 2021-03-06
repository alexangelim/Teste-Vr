PGDMP     6    6            
    x            teste-vr    10.14    10.14 6    +           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            ,           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            -           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            .           1262    16393    teste-vr    DATABASE     �   CREATE DATABASE "teste-vr" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE "teste-vr";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            /           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    4                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            0           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    2                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                  false            1           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                       false    1            �            1259    16445    ALUNO    TABLE     �   CREATE TABLE public."ALUNO" (
    codigo integer NOT NULL,
    matricula character varying NOT NULL,
    nome character varying NOT NULL,
    rg character varying NOT NULL,
    cpf character varying NOT NULL,
    curso character varying
);
    DROP TABLE public."ALUNO";
       public         postgres    false    4            �            1259    16443    ALUNO_codigo_seq    SEQUENCE     �   CREATE SEQUENCE public."ALUNO_codigo_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public."ALUNO_codigo_seq";
       public       postgres    false    4    201            2           0    0    ALUNO_codigo_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public."ALUNO_codigo_seq" OWNED BY public."ALUNO".codigo;
            public       postgres    false    200            �            1259    16484    CURSO    TABLE       CREATE TABLE public."CURSO" (
    codigo integer NOT NULL,
    descricao character varying NOT NULL,
    periodo character varying NOT NULL,
    qtd_aluno integer NOT NULL,
    carga_hor integer NOT NULL,
    cod_prof integer,
    duracao character varying NOT NULL
);
    DROP TABLE public."CURSO";
       public         postgres    false    4            �            1259    16482    CURSO_codigo_seq    SEQUENCE     �   CREATE SEQUENCE public."CURSO_codigo_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public."CURSO_codigo_seq";
       public       postgres    false    207    4            3           0    0    CURSO_codigo_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public."CURSO_codigo_seq" OWNED BY public."CURSO".codigo;
            public       postgres    false    206            �            1259    16468 
   DISCIPLINA    TABLE     6  CREATE TABLE public."DISCIPLINA" (
    codigo integer NOT NULL,
    descricao character varying NOT NULL,
    ementa character varying NOT NULL,
    limite_vaga integer NOT NULL,
    cod_prof integer NOT NULL,
    carga_hor integer NOT NULL,
    cod_curso integer,
    dia_semana character varying NOT NULL
);
     DROP TABLE public."DISCIPLINA";
       public         postgres    false    4            �            1259    16466    DISCIPLINA_codigo_seq    SEQUENCE     �   CREATE SEQUENCE public."DISCIPLINA_codigo_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public."DISCIPLINA_codigo_seq";
       public       postgres    false    4    205            4           0    0    DISCIPLINA_codigo_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public."DISCIPLINA_codigo_seq" OWNED BY public."DISCIPLINA".codigo;
            public       postgres    false    204            �            1259    16495 	   MATRICULA    TABLE     �   CREATE TABLE public."MATRICULA" (
    codigo integer NOT NULL,
    cod_aluno integer NOT NULL,
    cod_curso integer NOT NULL
);
    DROP TABLE public."MATRICULA";
       public         postgres    false    4            �            1259    16493    MATRICULA_codigo_seq    SEQUENCE     �   CREATE SEQUENCE public."MATRICULA_codigo_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public."MATRICULA_codigo_seq";
       public       postgres    false    209    4            5           0    0    MATRICULA_codigo_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public."MATRICULA_codigo_seq" OWNED BY public."MATRICULA".codigo;
            public       postgres    false    208            �            1259    16456 	   PROFESSOR    TABLE     �   CREATE TABLE public."PROFESSOR" (
    codigo integer NOT NULL,
    nome character varying NOT NULL,
    rg character varying NOT NULL,
    cpf character varying NOT NULL,
    titulo character varying NOT NULL
);
    DROP TABLE public."PROFESSOR";
       public         postgres    false    4            �            1259    16454    PROFESSOR_codigo_seq    SEQUENCE     �   CREATE SEQUENCE public."PROFESSOR_codigo_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public."PROFESSOR_codigo_seq";
       public       postgres    false    4    203            6           0    0    PROFESSOR_codigo_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public."PROFESSOR_codigo_seq" OWNED BY public."PROFESSOR".codigo;
            public       postgres    false    202            �            1259    16426 	   SEQ_ALUNO    SEQUENCE     w   CREATE SEQUENCE public."SEQ_ALUNO"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999
    CACHE 1;
 "   DROP SEQUENCE public."SEQ_ALUNO";
       public       postgres    false    4            �            1259    16428 	   SEQ_CURSO    SEQUENCE     w   CREATE SEQUENCE public."SEQ_CURSO"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999
    CACHE 1;
 "   DROP SEQUENCE public."SEQ_CURSO";
       public       postgres    false    4            �            1259    16430    SEQ_PROFESSOR    SEQUENCE     {   CREATE SEQUENCE public."SEQ_PROFESSOR"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999
    CACHE 1;
 &   DROP SEQUENCE public."SEQ_PROFESSOR";
       public       postgres    false    4            �
           2604    16448    ALUNO codigo    DEFAULT     p   ALTER TABLE ONLY public."ALUNO" ALTER COLUMN codigo SET DEFAULT nextval('public."ALUNO_codigo_seq"'::regclass);
 =   ALTER TABLE public."ALUNO" ALTER COLUMN codigo DROP DEFAULT;
       public       postgres    false    201    200    201            �
           2604    16487    CURSO codigo    DEFAULT     p   ALTER TABLE ONLY public."CURSO" ALTER COLUMN codigo SET DEFAULT nextval('public."CURSO_codigo_seq"'::regclass);
 =   ALTER TABLE public."CURSO" ALTER COLUMN codigo DROP DEFAULT;
       public       postgres    false    207    206    207            �
           2604    16471    DISCIPLINA codigo    DEFAULT     z   ALTER TABLE ONLY public."DISCIPLINA" ALTER COLUMN codigo SET DEFAULT nextval('public."DISCIPLINA_codigo_seq"'::regclass);
 B   ALTER TABLE public."DISCIPLINA" ALTER COLUMN codigo DROP DEFAULT;
       public       postgres    false    205    204    205            �
           2604    16498    MATRICULA codigo    DEFAULT     x   ALTER TABLE ONLY public."MATRICULA" ALTER COLUMN codigo SET DEFAULT nextval('public."MATRICULA_codigo_seq"'::regclass);
 A   ALTER TABLE public."MATRICULA" ALTER COLUMN codigo DROP DEFAULT;
       public       postgres    false    208    209    209            �
           2604    16459    PROFESSOR codigo    DEFAULT     x   ALTER TABLE ONLY public."PROFESSOR" ALTER COLUMN codigo SET DEFAULT nextval('public."PROFESSOR_codigo_seq"'::regclass);
 A   ALTER TABLE public."PROFESSOR" ALTER COLUMN codigo DROP DEFAULT;
       public       postgres    false    203    202    203                       0    16445    ALUNO 
   TABLE DATA               J   COPY public."ALUNO" (codigo, matricula, nome, rg, cpf, curso) FROM stdin;
    public       postgres    false    201   >:       &          0    16484    CURSO 
   TABLE DATA               f   COPY public."CURSO" (codigo, descricao, periodo, qtd_aluno, carga_hor, cod_prof, duracao) FROM stdin;
    public       postgres    false    207   ;       $          0    16468 
   DISCIPLINA 
   TABLE DATA               z   COPY public."DISCIPLINA" (codigo, descricao, ementa, limite_vaga, cod_prof, carga_hor, cod_curso, dia_semana) FROM stdin;
    public       postgres    false    205   �;       (          0    16495 	   MATRICULA 
   TABLE DATA               C   COPY public."MATRICULA" (codigo, cod_aluno, cod_curso) FROM stdin;
    public       postgres    false    209   P<       "          0    16456 	   PROFESSOR 
   TABLE DATA               D   COPY public."PROFESSOR" (codigo, nome, rg, cpf, titulo) FROM stdin;
    public       postgres    false    203   m<       7           0    0    ALUNO_codigo_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public."ALUNO_codigo_seq"', 15, true);
            public       postgres    false    200            8           0    0    CURSO_codigo_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public."CURSO_codigo_seq"', 6, true);
            public       postgres    false    206            9           0    0    DISCIPLINA_codigo_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public."DISCIPLINA_codigo_seq"', 15, true);
            public       postgres    false    204            :           0    0    MATRICULA_codigo_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public."MATRICULA_codigo_seq"', 1, false);
            public       postgres    false    208            ;           0    0    PROFESSOR_codigo_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public."PROFESSOR_codigo_seq"', 5, true);
            public       postgres    false    202            <           0    0 	   SEQ_ALUNO    SEQUENCE SET     :   SELECT pg_catalog.setval('public."SEQ_ALUNO"', 1, false);
            public       postgres    false    197            =           0    0 	   SEQ_CURSO    SEQUENCE SET     :   SELECT pg_catalog.setval('public."SEQ_CURSO"', 1, false);
            public       postgres    false    198            >           0    0    SEQ_PROFESSOR    SEQUENCE SET     >   SELECT pg_catalog.setval('public."SEQ_PROFESSOR"', 1, false);
            public       postgres    false    199            �
           2606    16453    ALUNO ALUNO_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public."ALUNO"
    ADD CONSTRAINT "ALUNO_pkey" PRIMARY KEY (codigo);
 >   ALTER TABLE ONLY public."ALUNO" DROP CONSTRAINT "ALUNO_pkey";
       public         postgres    false    201            �
           2606    16492    CURSO CURSO_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public."CURSO"
    ADD CONSTRAINT "CURSO_pkey" PRIMARY KEY (codigo);
 >   ALTER TABLE ONLY public."CURSO" DROP CONSTRAINT "CURSO_pkey";
       public         postgres    false    207            �
           2606    16476    DISCIPLINA DISCIPLINA_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public."DISCIPLINA"
    ADD CONSTRAINT "DISCIPLINA_pkey" PRIMARY KEY (codigo);
 H   ALTER TABLE ONLY public."DISCIPLINA" DROP CONSTRAINT "DISCIPLINA_pkey";
       public         postgres    false    205            �
           2606    16500    MATRICULA MATRICULA_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."MATRICULA"
    ADD CONSTRAINT "MATRICULA_pkey" PRIMARY KEY (codigo);
 F   ALTER TABLE ONLY public."MATRICULA" DROP CONSTRAINT "MATRICULA_pkey";
       public         postgres    false    209            �
           2606    16464    PROFESSOR PROFESSOR_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."PROFESSOR"
    ADD CONSTRAINT "PROFESSOR_pkey" PRIMARY KEY (codigo);
 F   ALTER TABLE ONLY public."PROFESSOR" DROP CONSTRAINT "PROFESSOR_pkey";
       public         postgres    false    203            �
           2606    16506    CURSO FK_CURSO_PROFESSOR    FK CONSTRAINT     �   ALTER TABLE ONLY public."CURSO"
    ADD CONSTRAINT "FK_CURSO_PROFESSOR" FOREIGN KEY (cod_prof) REFERENCES public."PROFESSOR"(codigo) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 F   ALTER TABLE ONLY public."CURSO" DROP CONSTRAINT "FK_CURSO_PROFESSOR";
       public       postgres    false    203    2713    207            �
           2606    16501    DISCIPLINA FK_DISCIPLINA_CURSO    FK CONSTRAINT     �   ALTER TABLE ONLY public."DISCIPLINA"
    ADD CONSTRAINT "FK_DISCIPLINA_CURSO" FOREIGN KEY (cod_curso) REFERENCES public."CURSO"(codigo) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 L   ALTER TABLE ONLY public."DISCIPLINA" DROP CONSTRAINT "FK_DISCIPLINA_CURSO";
       public       postgres    false    207    2717    205            �
           2606    16477    DISCIPLINA FK_DISCIPLINA_PROF    FK CONSTRAINT     �   ALTER TABLE ONLY public."DISCIPLINA"
    ADD CONSTRAINT "FK_DISCIPLINA_PROF" FOREIGN KEY (cod_prof) REFERENCES public."PROFESSOR"(codigo) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 K   ALTER TABLE ONLY public."DISCIPLINA" DROP CONSTRAINT "FK_DISCIPLINA_PROF";
       public       postgres    false    2713    203    205                �   x�m�1N1E��)|����.�H��؀�����,��R6K���� αˤ������/ ��}�_�I��{���F`ai����af{g���㾛����iP���!��>����So_�"����6��h]Є�q��T�����G�"�^~)������4�:���c�F�*�σ��]�yH�\�>8D��+K��Z�Ƙ+{&C�      &   �   x�3��q�uVpqU��s��u<�~�ٟ�/���(/��Ԁ�����ӈ�D���?�˄3�9(ԗ3,�� ��$��� �8M8�!JL9!Fn�tv�eT6���ˌӯ��(���Ë�R\2SK�,�LND6����H!1/��+F��� ��46      $   v   x�3��9�9=39Q!%U��(?�(17���Ë�9=�J��SJ��D�\�8AD�gpjzi^J��[jfQ"��)'�J����Լ�D��D����Ԓ�b� �f#�	���E%0b���� &g:      (      x������ � �      "   �   x�5��
�0 g�+��ɖ�B�:d�b�	�������pw�������{�O���ÏR��""L��+���������m?g��ӥs��a.��EY���M?�uы��R8�Q2����릔��F&�     