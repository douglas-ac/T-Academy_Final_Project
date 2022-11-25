export interface Login {
    username: string;
    password: string;
}

export interface AnnouncementList {
    id: number;
    amount: number;
    user: User;
    date: string;
    product: Product;
}

export interface Address {
    cep: string;
    logradouro?: string;
    complemento?: string;
    bairro?: string;
    localidade: string;
    uf: string;
    ddd?: string;
}

export interface User {
    id?: number;
    name: string;
    email: string;
    birthDate?: string;
    login?: Login;
    announcementList?: AnnouncementList[];
    nacionalNumber?: string;
    descriminationColumn?: string;
    fone: string;
    adress?: Address;
}

export interface Order {
    id: number;
    user: User;
    subTotal: number;
    discount: number;
    produtos: Product[];
}

export interface CommentAnswerDto {
    idCommentAnswer: number;
    message: string;
    user?: User;
    comment?: Comment;
    timeCreated: Date;
}

export interface Comment {
    id: number;
    message: string;
    user?: User;
    announcement? : Announce;
    commentAnswerDtos: CommentAnswerDto[];
}

export interface Announce {
    id: number;
    user: User;
    amount: number;
    date: Date;
    comments?: Comment[];
    product: Product;
}

export interface Product {
    id: number;
    nome: string;
    descricao: string;
    preco: number;
}

export interface Car extends Product{
    quilomatragem: number;
    modelo: string;
}

export interface Part {
    part_condition: string;
    category: string;
    automaker: string;
}