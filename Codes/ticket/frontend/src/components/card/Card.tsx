interface CardProps {
    id: number,
    description: string
}

const Card = ( props : CardProps) => {

    return (
        <div>
            <div>Id: {props.id}</div>
            <div>Description: {props.description}</div>
        </div>
    )

}

export default Card