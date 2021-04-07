package ru.example.api.responces;

import lombok.Data;
import ru.example.model.entities.Requests;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListRequestsResponse {

    private List<RequestResponse> userRequests;

    public ListRequestsResponse(List<Requests> requests) {
        userRequests = new ArrayList<>(requests.size());
        requests.forEach(request -> userRequests.add(new RequestResponse(request)));
    }
}