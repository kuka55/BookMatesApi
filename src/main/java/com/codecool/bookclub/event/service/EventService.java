package com.codecool.bookclub.event.service;

import com.codecool.bookclub.event.dto.EventDto;
import com.codecool.bookclub.event.model.Event;
import com.codecool.bookclub.event.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private EventRepository eventRepository;

//    public EventServiceImplementation(EventRepository eventRepository){this.eventRepository = eventRepository;}
//
//
//    @Override
//    public List<EventDto> findAllEvents() {
//        List<Event> events = eventRepository.findAll();
//        return events.stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList());
//    }
//
//    @Override
//    public Event saveEvent(Event event) {
//        return eventRepository.save(event);
//    }
//
//    @Override
//    public EventDto findEventById(long id) {
//       Event event = eventRepository.findById(id).get();
//       return mapToEventDto(event);
//    }

    private EventDto mapToEventDto(Event event){
        EventDto eventDto = EventDto.builder()
                .id(event.getId())
                .creationDateAndTime(event.getCreationDateAndTime())
                .title(event.getTitle())
                .build();
        return eventDto;
    }
}
