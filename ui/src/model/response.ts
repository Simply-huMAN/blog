import { Metadata } from "./metadata";

export abstract class Response {
    metadata: Metadata;

    constructor(metadata: Metadata) {
        this.metadata = metadata;
    }
}