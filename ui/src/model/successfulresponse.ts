import { Metadata } from "./metadata";
import { Response } from "./response";

export class SuccessResponse<T> extends Response {
    data: T;

    constructor(metadata: Metadata, data: T) {
        super(metadata);
        this.data = data;
    }
}
