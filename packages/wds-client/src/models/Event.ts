import { unionize, ofType, UnionOf } from 'unionize'
import { RequestFromApi, ApiRequest } from './ApiRequest'

export interface EventData {
  name: string
  sponsor: string
  contact: string
  date: string
  details: string
  location: string
  status: string
  maxParticipants: number
  registrationOpens: string
  createdOn: string
  updatedOn: string
}

export const Event = unionize({
  NONE: {},
  LOADING: {},
  ERROR: {},
  OPEN: ofType<{ data: EventData }>(),
  OPEN_WITH_REGISTRATION: ofType<{ data: EventData }>(),
  OPEN_WITH_WAITLIST: ofType<{ data: EventData }>(),
  OPEN_FULL: ofType<{ data: EventData }>(),
  CLOSED: ofType<{ data: EventData }>(),
  CLOSED_WITH_FEEDBACK: ofType<{ data: EventData }>(),
  CANCELLED: ofType<{ data: EventData }>()
})

export type CurrentEvent = UnionOf<typeof Event>

export const mapRequestToEvent = (request: RequestFromApi): CurrentEvent =>
  ApiRequest.match(request, {
    LOADING: () => Event.LOADING(),
    NOT_OK: () => Event.ERROR(),
    OK: ({ data }: { data: { currentEvent: EventData } }) => {
      // TODO: map status -> Event type
      const { currentEvent } = data
      return Event.OPEN({ data: currentEvent })
    },
    default: data => {
      return Event.NONE()
    }
  })