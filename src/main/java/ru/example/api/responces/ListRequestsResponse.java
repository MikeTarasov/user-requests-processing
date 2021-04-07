package ru.example.api.responces;

import lombok.Data;
import ru.example.model.entities.Request;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListRequestsResponse {

    private List<RequestResponse> userRequests;

    public ListRequestsResponse(List<Request> requests) {
        userRequests = new ArrayList<>(requests.size());
        requests.forEach(request -> userRequests.add(new RequestResponse(request)));
    }
}